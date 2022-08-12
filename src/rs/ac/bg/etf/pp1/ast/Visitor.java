// generated with ast extension for cup
// version 0.8
// 12/7/2022 8:46:4


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(MethodDeclListNullable MethodDeclListNullable);
    public void visit(ActParsOptional ActParsOptional);
    public void visit(ExprOptional ExprOptional);
    public void visit(Mulop Mulop);
    public void visit(StatementListNullable StatementListNullable);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(AddopTermListNullable AddopTermListNullable);
    public void visit(Var Var);
    public void visit(RelopExprOptional RelopExprOptional);
    public void visit(ConstName ConstName);
    public void visit(ProgramDecl ProgramDecl);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(VarList VarList);
    public void visit(ClassExtendsOptional ClassExtendsOptional);
    public void visit(Designator Designator);
    public void visit(Condition Condition);
    public void visit(FormParsOptional FormParsOptional);
    public void visit(ClassBodyMethodsOptional ClassBodyMethodsOptional);
    public void visit(SingleStatementPrintNumConstOptional SingleStatementPrintNumConstOptional);
    public void visit(Expr Expr);
    public void visit(SingleStatementElseOptional SingleStatementElseOptional);
    public void visit(ActPars ActPars);
    public void visit(ProgramDeclListNullable ProgramDeclListNullable);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(MethodReturnType MethodReturnType);
    public void visit(ConstAssignList ConstAssignList);
    public void visit(ConstAssign ConstAssign);
    public void visit(MulopFactorListNullable MulopFactorListNullable);
    public void visit(Statement Statement);
    public void visit(FactorType FactorType);
    public void visit(VarDeclListNullable VarDeclListNullable);
    public void visit(FormPar FormPar);
    public void visit(SingleStatement SingleStatement);
    public void visit(FormPars FormPars);
    public void visit(Mod Mod);
    public void visit(Div Div);
    public void visit(Mul Mul);
    public void visit(Minus Minus);
    public void visit(Plus Plus);
    public void visit(LessOrEqualTo LessOrEqualTo);
    public void visit(LessThan LessThan);
    public void visit(GreaterOrEqualTo GreaterOrEqualTo);
    public void visit(GreaterThan GreaterThan);
    public void visit(NotEqual NotEqual);
    public void visit(IsEqual IsEqual);
    public void visit(Assign Assign);
    public void visit(Label Label);
    public void visit(DesignatorDefault DesignatorDefault);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(DesignatorClassEntity DesignatorClassEntity);
    public void visit(EmptyMulopFactorList EmptyMulopFactorList);
    public void visit(MulopFactorList MulopFactorList);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNewUserType FactorNewUserType);
    public void visit(FactorNewArray FactorNewArray);
    public void visit(FactorConstBool FactorConstBool);
    public void visit(FactorConstChar FactorConstChar);
    public void visit(FactorConstNum FactorConstNum);
    public void visit(FactorDesignatorMethod FactorDesignatorMethod);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(EmptyAddopTermList EmptyAddopTermList);
    public void visit(AddopTermList AddopTermList);
    public void visit(Term Term);
    public void visit(RelopExprNo RelopExprNo);
    public void visit(RelopExprYes RelopExprYes);
    public void visit(ExprNo ExprNo);
    public void visit(ExprYes ExprYes);
    public void visit(ExprNegQQ ExprNegQQ);
    public void visit(ExprQQ ExprQQ);
    public void visit(ExprNegTerm ExprNegTerm);
    public void visit(ExprTerm ExprTerm);
    public void visit(CondFact CondFact);
    public void visit(CondTermMany CondTermMany);
    public void visit(CondTermSingle CondTermSingle);
    public void visit(ConditionError ConditionError);
    public void visit(ConditionMany ConditionMany);
    public void visit(ConditionSingle ConditionSingle);
    public void visit(ActParsNo ActParsNo);
    public void visit(ActParsYes ActParsYes);
    public void visit(ActParsMany ActParsMany);
    public void visit(ActParsSingle ActParsSingle);
    public void visit(ErrorDesignatorStatementAssign ErrorDesignatorStatementAssign);
    public void visit(DesignatorStatementPostDec DesignatorStatementPostDec);
    public void visit(DesignatorStatementPostInc DesignatorStatementPostInc);
    public void visit(DesignatorStatementFunctionCall DesignatorStatementFunctionCall);
    public void visit(DesignatorStatementAssign DesignatorStatementAssign);
    public void visit(Statements Statements);
    public void visit(SingleStatementPrintNumConstNo SingleStatementPrintNumConstNo);
    public void visit(SingleStatementPrintNumConstYes SingleStatementPrintNumConstYes);
    public void visit(SingleStatementElseNo SingleStatementElseNo);
    public void visit(SingleStatementElseYes SingleStatementElseYes);
    public void visit(SingleStatementPrint SingleStatementPrint);
    public void visit(SingleStatementRead SingleStatementRead);
    public void visit(SingleStatementReturn SingleStatementReturn);
    public void visit(SingleStatementContinue SingleStatementContinue);
    public void visit(SingleStatementBreak SingleStatementBreak);
    public void visit(SingleStatementDo SingleStatementDo);
    public void visit(SingleStatementIf SingleStatementIf);
    public void visit(SingleStatementDesignatorStatement SingleStatementDesignatorStatement);
    public void visit(EmptyStatementList EmptyStatementList);
    public void visit(StatementList StatementList);
    public void visit(StatementBlock StatementBlock);
    public void visit(StatementSingle StatementSingle);
    public void visit(StatementLabeled StatementLabeled);
    public void visit(Type Type);
    public void visit(FormParsNo FormParsNo);
    public void visit(FormParsYes FormParsYes);
    public void visit(FormParName FormParName);
    public void visit(FormParType FormParType);
    public void visit(FormParError FormParError);
    public void visit(FormParArray FormParArray);
    public void visit(FormParSingle FormParSingle);
    public void visit(FormParsMany FormParsMany);
    public void visit(FormParsSingle FormParsSingle);
    public void visit(EmptyMethodDeclList EmptyMethodDeclList);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(MethodName MethodName);
    public void visit(MethodReturnTypeVoid MethodReturnTypeVoid);
    public void visit(MethodReturnTypeRegular MethodReturnTypeRegular);
    public void visit(MethodDecl MethodDecl);
    public void visit(ClassBodyMethodsNo ClassBodyMethodsNo);
    public void visit(ClassBodyMethodsYes ClassBodyMethodsYes);
    public void visit(ClassBody ClassBody);
    public void visit(ClassParentType ClassParentType);
    public void visit(ClassExtendsNo ClassExtendsNo);
    public void visit(ClassExtendsYes ClassExtendsYes);
    public void visit(ClassName ClassName);
    public void visit(ClassDecl ClassDecl);
    public void visit(EmptyVarDeclListNullable EmptyVarDeclListNullable);
    public void visit(VarDeclList VarDeclList);
    public void visit(VarError VarError);
    public void visit(VarArray VarArray);
    public void visit(VarSingle VarSingle);
    public void visit(VarListMany VarListMany);
    public void visit(VarListSingle VarListSingle);
    public void visit(VarType VarType);
    public void visit(VarDecl VarDecl);
    public void visit(ConstAssignBool ConstAssignBool);
    public void visit(ConstAssignChar ConstAssignChar);
    public void visit(ConstAssignNum ConstAssignNum);
    public void visit(ConstListMany ConstListMany);
    public void visit(ConstListSingle ConstListSingle);
    public void visit(ConstType ConstType);
    public void visit(ConstDecl ConstDecl);
    public void visit(ProgramDeclClass ProgramDeclClass);
    public void visit(ProgramDeclVar ProgramDeclVar);
    public void visit(ProgramDeclConst ProgramDeclConst);
    public void visit(EmptyProgramDeclList EmptyProgramDeclList);
    public void visit(ProgramDeclList ProgramDeclList);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
