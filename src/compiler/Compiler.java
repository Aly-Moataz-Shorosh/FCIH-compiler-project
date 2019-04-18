/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;
import parser.parser;
import view.compilerMainView ;
/**
 *
 * @author user
 */
public class Compiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        compilerMainView mainView = new compilerMainView();
        mainView.show();
      /*  parser parser=new parser("@craf ID{Sipokf x ;}#");

                parser.algorithm();*/
    }
    
}
