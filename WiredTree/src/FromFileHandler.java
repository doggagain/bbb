import java.util.Scanner;

public class FromFileHandler extends InputHandler {
    public FromFileHandler(){
        super();
    }
    public BinarySearchTree<Student> GetInput(){
        System.out.print("\nEnter location of file:");
        String path= "/home/mosh/to/bbb/WiredTree/src/exam.txt";//new Scanner(System.in).nextLine();
        BinaryParser parser=new BinaryParser();
        return parser.ReadFile(path); 
    }
}