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
		if (args.length < 1) {
			log.error("Error! <source-file> not provided as an argument.");
			return;
		}
		
		File sourceCode = new File(args[0]);
		if (!sourceCode.exists()) {
			log.error("Source file [" + sourceCode.getAbsolutePath() + "] not found!");
			return;
		}
			
		log.info("Compiling source file: " + sourceCode.getAbsolutePath());
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))) {
			Yylex lexer = new Yylex(br);
			MJParser parser = new MJParser(lexer);
	        Symbol s = parser.parse();
	        
	        Program prog = (Program)(s.value);
	        
	        if (!parser.errorDetected) {
	        	//print syntax tree
		        log.info(prog.toString(""));
		        log.info("===========================");
	        	log.info("Parsing SUCCESSFUL!");
	        }
	        else {
	        	log.info("===========================");
	        	log.error("Parsing FAILED!");
	        }
		}
	}
}
