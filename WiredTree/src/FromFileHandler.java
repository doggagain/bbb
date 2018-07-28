import java.util.Scanner;

public class FromFileHandler extends InputHandler {
    public FromFileHandler(){
        super();
    }
    public String[] GetInput(BinarySearchTree<Student> tree){
        System.out.print("\nEnter location of file:");
        String path= new Scanner(System.in).nextLine();
        BinaryParser parser=new BinaryParser();
        return parser.ReadFile(path,tree); 
    }
}