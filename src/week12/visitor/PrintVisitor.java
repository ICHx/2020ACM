package week12.visitor;

public class PrintVisitor implements FileSystemVisitor {
   public void visitFileNode(FileNode node) {
      for (int i = 0; i < level; i++)
         System.out.print(" ");

      name = node.getFile().getName();
      details = node.getDetails();
      System.out.println("♯ "+name + "\t\t\t\t" + details);
   }

   public void visitDirectoryNode(DirectoryNode node) {
      for (int i = 0; i < level; i++)
         System.out.print(" ");

      name = node.getDirectory().getName();
      details = node.getDetails();
      //Meaning group: seperate folders from files by symbol
      System.out.println("▼ "+name + "\t\t" + details);
      
      //Meaning group: increase identation for clearer view
      level+=2;
      for (FileSystemNode c : node.getChildren())
         c.accept(this);
      level-=2;
   }

   private int level = 0;
   private String name;
   private String details;
}
