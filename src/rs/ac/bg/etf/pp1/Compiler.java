package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class Compiler {
	
	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger(Compiler.class);
		if (args.length < 2) {
			log.error("Error! Provide <source-file> and <output-file> as command line arguments.");
			return;
		}
		
		File sourceCode = new File(args[0]);
		if (!sourceCode.exists()) {
			log.error("Source file [" + sourceCode.getAbsolutePath() + "] not found!");
			return;
		}
			
		log.info("Compiling source file: " + sourceCode.getAbsolutePath());
		
		log.info("=====================================");
    	log.info("PARSING...");
		try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))) {
			Yylex lexer = new Yylex(br);
			MJParser parser = new MJParser(lexer);
	        Symbol s = parser.parse();
	        
	        if (!parser.errorDetected) {
	        	Program prog = (Program)(s.value);
	        	//print syntax tree
		        log.info(prog.toString(""));
	        	log.info("PARSING SUCCESSFUL!");
	        	log.info("=====================================");
	        	log.info("SEMANTIC ANALYSIS...");
	        	TabEx.init();
	        	SemanticAnalyzer semanticAnalyzer=new SemanticAnalyzer();
	        	prog.traverseBottomUp(semanticAnalyzer);
	        	if(!semanticAnalyzer.errorDetected) {
	        		log.info("SEMANTIC ANALYSIS SUCCESSFUL!");
		        	log.info("=====================================");
		        	log.info("CODE GENERATION...");
		        	//file stuff
		        	File outputFile=new File(args[1]);
		        	FileOutputStream outputFileStream=new FileOutputStream(outputFile);
		        	if(outputFile.exists()) {
		        		outputFile.delete();
		        	}
		        	CodeGenerator codeGenerator=new CodeGenerator();
		        	prog.traverseBottomUp(codeGenerator);
		        	Code.dataSize=semanticAnalyzer.getNumberOfGlobalVariables();
		        	Code.mainPc=codeGenerator.getMainPc();
		        	if(Code.greska==true) {
			        	log.info("CODE GENERATION FAILED! RUNTIME ERROR(S) DETECTED!");
		        	}
		        	else {
			        	log.info("CODE GENERATION SUCCESSFUL!");
			        	log.info("Results saved in the output file "+outputFile.getPath()+".");
		        		Code.write(outputFileStream);
		        	}
		        	outputFileStream.close();
	        	}
	        	else {
	        		log.info("=====================================");
		        	log.error("SEMANTIC ANALYSIS FAILED! SEMANTIC ERROR(S) DETECTED!");
	        	}
	        }
	        else {
	        	log.info("=====================================");
	        	log.error("PARSING FAILED! PARSING ERROR(S) DETECTED!");
	        }
		}
	}
}
