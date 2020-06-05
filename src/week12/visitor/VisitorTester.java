package week12.visitor;

import java.io.*;

import javax.swing.JFileChooser;

public class VisitorTester {
   public static void main (String[] args) throws IOException{
      
      JFileChooser chosen = new JFileChooser(new File("."));
      chosen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      if(chosen.showOpenDialog(null)!=JFileChooser.APPROVE_OPTION){
         System.out.println("No valid folder chosen");
         System.exit(1);
      }
      File f = chosen.getSelectedFile();
      DirectoryNode node = new DirectoryNode( f);
      node.accept( new PrintVisitor() );
   }   
}
