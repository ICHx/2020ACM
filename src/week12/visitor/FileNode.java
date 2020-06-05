package week12.visitor;
import java.io.*;
public class FileNode implements FileSystemNode {
   public FileNode (File file) {
      this.file = file;
   }

   public File getFile () { return file; }
   
   public String getDetails(){ return FSDetails.returnDetails(file, true);}

   public void accept (FileSystemVisitor v) {
      v.visitFileNode( this ); 
   }

   private File file;
}
