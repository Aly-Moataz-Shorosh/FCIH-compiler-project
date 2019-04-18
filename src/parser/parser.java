/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.Stack;

/**
 *
 * @author Shimaa
 */
public class parser {

    /**
     * @param args the command line arguments
     */
    //input
   public String input="";
   private int indexOfInput=-1;
    //Stack
    Stack <String> stack=new Stack<String>();
    //Table of rules
    String [][] table=
    {
        {"Start-Symbols ClassDeclaration End-Symbols","Start-Symbols ClassDeclaration End-Symbols",
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,
        }
            ,
        {"@","^",
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,
        
        }
            ,
        { null,null,"$","#",null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
            ,
        {null,null,null,null,"Type ID{ Class_Implementation}||Type ID Infer { Class_Implementation}",
                             "Type ID{ Class_Implementation}||Type ID Infer { Class_Implementation}",
                             "Type ID{ Class_Implementation}||Type ID Infer { Class_Implementation}",
                             "Type ID{ Class_Implementation}||Type ID Infer { Class_Implementation}",
                             "Type ID{ Class_Implementation}||Type ID Infer { Class_Implementation}",
                             "Type ID{ Class_Implementation}||Type ID Infer { Class_Implementation}",
                             "Type ID{ Class_Implementation}||Type ID Infer { Class_Implementation}",
                             "Type ID{ Class_Implementation}||Type ID Infer { Class_Implementation}"
         ,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
            ,
          {null,null,null,null,
              "Variable_Decl Class_Implementation||em",
               "Variable_Decl Class_Implementation||em",
                "Variable_Decl Class_Implementation||em",
                 "Variable_Decl Class_Implementation||em",
                  "Variable_Decl Class_Implementation||em",
                   "Variable_Decl Class_Implementation||em",
                    "Variable_Decl Class_Implementation||em",
                     "Variable_Decl Class_Implementation||em",
                      "Variable_Decl Class_Implementation||em",
                       "Variable_Decl Class_Implementation||em",
                        "Variable_Decl Class_Implementation||em",
                         "Variable_Decl Class_Implementation||em",
                          "Variable_Decl Class_Implementation||em",
                          null,
                             "Variable_Decl Class_Implementation||em",
                              "Variable_Decl Class_Implementation||em",
         null,
          "Variable_Decl Class_Implementation||em",
           "Variable_Decl Class_Implementation||em",
            "Variable_Decl Class_Implementation||em",
             "Variable_Decl Class_Implementation||em",
              "Variable_Decl Class_Implementation||em",
               "Variable_Decl Class_Implementation||em",
                "Variable_Decl Class_Implementation||em",null,null,
         "Variable_Decl Class_Implementation||em", 
        null,null,null,null,null,null,null,
        
         "Variable_Decl Class_Implementation||em",
          "Variable_Decl Class_Implementation||em",
         null,null,null,
           "Variable_Decl Class_Implementation||em",
          }
            ,
          {
          null,null,null,null,
              " Func Decl ;|| Func Decl { Variable_Decl Statements }",
              " Func Decl ;|| Func Decl { Variable_Decl Statements }",
              " Func Decl ;|| Func Decl { Variable_Decl Statements }",
              " Func Decl ;|| Func Decl { Variable_Decl Statements }",
              " Func Decl ;|| Func Decl { Variable_Decl Statements }",
              " Func Decl ;|| Func Decl { Variable_Decl Statements }",
              " Func Decl ;|| Func Decl { Variable_Decl Statements }",
              " Func Decl ;|| Func Decl { Variable_Decl Statements }",
         null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null
          }
            ,
        { null,null,null,null,
           "Type ID (ParameterList)",
           "Type ID (ParameterList)",
           "Type ID (ParameterList)",
           "Type ID (ParameterList)",
           "Type ID (ParameterList)",
           "Type ID (ParameterList)",
           "Type ID (ParameterList)",
           "Type ID (ParameterList)",
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null}
            ,
        {
         null,null,null,null,
            "Ipok","Sipok" ,"Craf" ,"Sequence" ,"Ipokf" ,"Sipokf" ,"Valueless" ,"Rational"
              ,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null
        }
            
                   ,
        {
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,"em||Non-Empty List",null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"em||Non-Empty List",
         "None","Non-Empty List",null,null
        }
                 ,
        { null,null,null,null,
           "Type ID Non-Empty List’",
           "Type ID Non-Empty List’",
           "Type ID Non-Empty List’",
           "Type ID Non-Empty List’",
           "Type ID Non-Empty List’",
           "Type ID Non-Empty List’",
           "Type ID Non-Empty List’",
           "Type ID Non-Empty List’",
           null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
            
                         ,
        { null,null,null,null,
               "Type ID Non-Empty List’",
               "Type ID Non-Empty List’",
               "Type ID Non-Empty List’",
               "Type ID Non-Empty List’",
               "Type ID Non-Empty List’",
               "Type ID Non-Empty List’",
               "Type ID Non-Empty List’",
               "Type ID Non-Empty List’",
               null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"em",
         null,null,null,null}
                         ,
        { null,null,null,null,
            "em||Type ID_List ;||Variable_Decl",
            "em||Type ID_List ;||Variable_Decl",
            "em||Type ID_List ;||Variable_Decl",
            "em||Type ID_List ;||Variable_Decl",
            "em||Type ID_List ;||Variable_Decl",
            "em||Type ID_List ;||Variable_Decl",
            "em||Type ID_List ;||Variable_Decl",
            "em||Type ID_List ;||Variable_Decl",
        "em||Variable_Decl","em||Variable_Decl",null,null,"em||Variable_Decl",null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,"em||Variable_Decl","em||Variable_Decl",
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"ID ID_List’",
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,"em",null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"ID ID_List’",
         null,null,null,null}
                         ,
        { null,null,null,null,
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
            "em||Statement Statements",
         "Statement Statements",null,"em||Statement Statements",
         null,
         "em||Statement Statements",
         "em||Statement Statements",
         "em||Statement Statements",
         "em||Statement Statements",
         "em||Statement Statements",
         "em||Statement Statements",
         "em||Statement Statements",
         null,null,
         "em||Statement Statements",
         "Statement Statements",
          "Statement Statements",
           "Statement Statements",
            "Statement Statements",
             "Statement Statements",
              "Statement Statements",
               "Statement Statements",
        "em||Statement Statements",
        "em||Statement Statements",
         null,null,null,null}
                         ,
        { null,null,null,null,
           "Assignment",
            "Assignment",
             "Assignment",
              "Assignment",
               "Assignment",
                "Assignment",
            "Assignment",
             "Assignment",
              "Assignment",
               "Assignment",
                "Assignment",
                "Assignment",
                "Assignment"
         ,"If _Statement",null,"Assignment",
         null,"Assignment","Assignment","Assignment","Assignment","Assignment","Assignment","Assignment",
         null,
         null,"Assignment","However _Statement","when_Statement","Respondwith _ Statement","Respondwith _ Statement",
        "Endthis _Statement","Scanvalur (ID );","Print (Expression);",
         "Assignment","Assignment",null,null,null,null}
                         ,
        { null,null,null,null,
         " Variable_Decl = Expression;",  
         " Variable_Decl = Expression;",
         " Variable_Decl = Expression;",
         " Variable_Decl = Expression;",
         " Variable_Decl = Expression;",
         " Variable_Decl = Expression;",  
         " Variable_Decl = Expression;",
         " Variable_Decl = Expression;",
         " Variable_Decl = Expression;",
         " Variable_Decl = Expression;"
        ,null,null,
         " Variable_Decl = Expression;",null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,
         " Variable_Decl = Expression;",  
         " Variable_Decl = Expression;",
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"ID (Argument_List) ;",
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,"em","em",null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"em||NonEmpty_Argument_List",
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"Expression NonEmpty_Argument_List’",
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,"em","em",null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"em",
         null," , Expression NonEmpty_Argument_List’",null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,"{ statements }",null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,
         "if (Condition _Expression) Block Statements||if (Condition _Expression) Block Statements else Block Statements",
         null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"Condition ||Condition Condition _Op Condition",
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,"&&","||",
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null," Expression Comparison _Op Expression",
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,"==","!=",">",">=","<","<=",null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,"However (Condition _Expression) Block Statements",null,null,null,null,null,null,null,null,
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null," when ( expression ; expression ; expression ) Block Statements",null,null,null,null,null,null,null,
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,"Respondwith Expression ;"," return ID ;",null,null,null,null,null,
         null,null,null,null}
                         ,
        { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null," Endthis;",null,null,null,null,
         null,null,null,null}
            ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"Term Expression’",
         null,null,null,null}
            ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,"em","em"," Add_Op Term Expression’"," Add_Op Term Expression’",null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"em",
         null,null,null,null}
                   ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,"+","-",null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
                       ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"Factor Term’",
         null,null,null,null}
                       ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,"Mul_Op Term’||em","Mul_Op Term’||em",null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
                       ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,"*","/",null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
                             ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,"ID",
         null,null,"Number",null}
                             ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,"***STR","/$ STR $ /",null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null}
                             ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,"Require(F_name.txt);",null,
         null,null,null,null}
                             ,
         { null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,null,null,null,null,null,null,null,
         null,null,null,"STR"}
       
     };
    
    String [] nonTers={"program","start_symbols","End-Symbols","ClassDeclaration","Class_Implementation",
                       "Method_Decl","Func Decl","Type","ParameterList","Non-Empty List","Non-Empty List’","Variable_Decl",
                       "ID_List","ID_List’","Statements" , "Statement","Assignment","Func _Call","Argument_List",
                       "NonEmpty_Argument_List","NonEmpty_Argument_List’","Block Statements","If _Statement",
                       "Condition _Expression","Condition _Op","Condition","Comparison _Op","However _Statement",
                       "when _Statement","Respondwith _Statement","Endthis _Statement","Expression","Expression’",
                       "Add_Op","Term","Term'","Mul_Op","Factor","Comment","Require_command","F_name"
                     };
    String [] terminals={"@","^","$","#","Ipok","Sipok","Craf","Sequence","Ipokf","Sipokf",
                         "Valueless","Rational","*","/","+","-",";","if","{","}",
                         "(",")","==","!=",">",">=","<","<=","&&","||",
                         "else","however","when","respondwith","return","endthis","scandvalur","prin","require","ID",
                         "none",",","number","."
                        };


    public parser(String in)
      {
         this.input=in;
      }

    private  void pushRule(String rule)
      {
        for(int i=rule.length()-1;i>=0;i--)
         {
         char ch=rule.charAt(i);
         String str=String.valueOf(ch);
         push(str);
         }
      }
       //algorithm
    public void algorithm    ()
    {
        push(this.input.charAt(0)+"");//
        push("program");
    //Read one token from input
    
        String token=read();
        String top=null;
    
      do
      {
               top=this.pop();
            //if top is non-terminal
        if(isNonTerminal(top))
        {
        String rule=this.getRule(top, token);
        this.pushRule(rule);
        }
        else if(isTerminal(top))
        {
        if(!top.equals(token))
        {
           error("this token is not correct , By Grammer rule . Token : ("+token+")");
        }
        else
        {
           System.out.println("Matching: Terminal :( "+token+" )");
            token =read();
            top=pop();

        }
        
        }
        else
        {
        error("Never Happens , Because top : ( "+top+" )");
        }
        if(token.equals("$"))
        {
        break;
        }
        //if top is terminal
    
    }while(true);//out of the loop when $
    
        
    //accept
    if(token.equals("$"))
        {
         System.out.println("Input is Accepted by LL1");   
        }
    else
    {
     System.out.println("Input is not Accepted by LL1");   
    }
}
   private boolean isTerminal(String s) {
               for(int i=0;i<this.terminals.length;i++)
        {
        if(s.equals(this.terminals[i]))
        {
        return true;
        }

        }
              return false;
    }
   
    private boolean isNonTerminal(String s) {
        for(int i=0;i<this.nonTers.length;i++)
        {
        if(s.equals(this.nonTers[i]))
        {
        return true;
        }

        }
              return false;
    }

    private String read() {
        indexOfInput++;
        char ch=this.input.charAt(indexOfInput);
        String str=String.valueOf(ch);

        return str;
    }

        private void push(String s) {
            this.stack.push(s);   
    }
        private String pop() {
          return this.stack.pop();   
    }

    private void error(String message) {
        System.out.println(message);
        throw new RuntimeException(message);
    }
    public String getRule(String non,String term)
    {
        
    int row=getnonTermIndex(non);
    int column=getTermIndex(term);
    String rule=this.table[row][column];
    if(rule==null)
    {
    error("There is no Rule by this , Non-Terminal("+non+") ,Terminal("+term+") ");
    }
    return rule;
    }
       private int getnonTermIndex(String non) {
       for(int i=0;i<this.nonTers.length;i++)
       {
       if(non.equals(this.nonTers[i]))
       {
       return i;
       }
       }
       error(non +" is not NonTerminal");
       return -1;
    }

    private int getTermIndex(String term) {
              for(int i=0;i<this.terminals.length;i++)
       {
       if(term.equals(this.terminals[i]))
       {
       return i;
       }
       }
       error(term +" is not Terminal");
       return -1;
    }


}

