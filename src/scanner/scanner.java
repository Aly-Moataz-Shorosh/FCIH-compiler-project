/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.util.ArrayList;
import java.util.List;
import dictionary.dictionary;

/**
 *
 * @author user
 */
public class scanner {
    
    List<String> tokens ;
    List<Integer> errorTokenIndex ;
    List<Integer> lineNum ;
    dictionary keywords ;
    
    public scanner()
    {
         tokens = new ArrayList<>();
         errorTokenIndex = new ArrayList<>();
         lineNum = new ArrayList<>();
         keywords = new dictionary();
         intitKeywords();
    }
    
    public void generateScanner(char input[])
    {
        String token ="" ;
        int lineNUM =1;
        //System.out.println(input);
        for (int i = 0; i < input.length; i++){
            char c = input[i];  
            
            //System.out.println(c);
            if(c == ' ' || c == '\n' || c == '\t' || c == ';')
            {
                if( c == '\n')
                {
                    
                    lineNUM++;
                }
                
                lineNum.add(lineNUM);
                tokens.add(token);
                
                if(keywords.get(token) == null)
                {
                    errorTokenIndex.add(1);  // assume that 1 is error
                }
                else
                {
                    errorTokenIndex.add(0);  // assume that 0 is error
                }
           //     System.out.println(token);
                token = "";
                
                
                
            } else {
                token += c;
            }
            
        }
        
    }
    
    public String getResult()
    {
        String result ;
        result = "THE RESULT OF THE SCANNER\n";
        for(int i = 0; i < errorTokenIndex.size(); i++)
        {
            if(errorTokenIndex.get(i) == 0)
            {
                result += "Line #:";
                result += lineNum.get(i);
                result += " | Token Text: ";
                result += tokens.get(i);
                result += " | Token Type: ";
                result += keywords.get(tokens.get(i));
                
                result+="\n";
                
            //    System.out.println(tokens.get(i));
            //    System.out.println(keywords.get(tokens.get(i)));
            }
            else
            {
                result += "Line #:";
                result += lineNum.get(i);
                result += " | Error in Token Text: ";
                result += tokens.get(i);
                result+="<<<<<<<<<<<<<<<<<<<<<<<<<<<<< \n";
            }
            
          //  System.out.println(result);
        }
        return result ;
    }
    
    public void intitKeywords()
    {
        keywords.put("@", "Starting Sympol");
        keywords.put("^", "Starting Sympol");
        keywords.put("$", "Ending Sympol");
        keywords.put("#", "Ending Sympol");
        keywords.put("Ipok", "Object Type");
        keywords.put("Sipok", "Object Type");
        keywords.put("Craf", "Object Type");
        keywords.put("Sequence", "Object Type");
        keywords.put("Ipokf", "Object Type");
        keywords.put("Sipokf", "Object Type");
        keywords.put("Valueless", "Object Type");
        keywords.put("Rational", "Object Type");
        keywords.put("*", "Arithmetic operation");
        keywords.put("/", "Arithmetic operation");
        keywords.put("+", "Arithmetic operation");
        keywords.put("-", "Arithmetic operation");
        keywords.put("if", "codition statment if");
        keywords.put("==", "Logic operator");
        keywords.put("!=", "Logic operator");
        keywords.put(">", "Logic operator");
        keywords.put(">=", "Logic operator");
        keywords.put("<", "Logic operator");
        keywords.put("<=", "Logic operator");
        keywords.put("&&", "Logic operator");
        keywords.put("||", "Logic operatorp");
        keywords.put("else", "codition statment else");
        keywords.put("when", "LOOP");
        keywords.put("however", "LOOP");
        keywords.put("respondwith", "Return");
        keywords.put("endthis", "BREAK");
        keywords.put("scandvalur", "scan value");
        keywords.put("print", "print func");
        keywords.put("require", "inclusion");
        keywords.put(";", "Quatatuion Mark");
        keywords.put("=", "Assignment operator");
        keywords.put("~", "Logic operator");
        keywords.put("->", "Access Operator");
        keywords.put("***", "COMMENT ONE LINE");
        keywords.put("/$", "Start MULTIPLE LINE COMMENT");
        keywords.put("$/", "Start MULTIPLE LINE COMMENT");
        keywords.put("Srap", "struct");
        keywords.put("Scan", "Switch");
        keywords.put("Conditionof", "Switch");
        
        keywords.put("{", "Braces");
        keywords.put("}", "Braces");
        keywords.put(")", "Braces");
        keywords.put("(", "Braces");
        
        
        
    }
    
}
