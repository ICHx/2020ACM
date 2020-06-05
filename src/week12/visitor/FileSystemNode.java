/**
   The common interface for file and directory nodes.
*/
package week12.visitor;
public interface FileSystemNode {
   String getDetails();
   void accept (FileSystemVisitor v);
}
