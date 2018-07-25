import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args)
    {
        BinarySearchTree<Student> tree = TakeInput();
        int a=6;
        //tree.Delete(new Student("7#dsajkndjas"));
        System.out.println(tree.GetMaximum().GetKey());
        System.out.println(tree.GetMinimum().GetKey());
        System.out.println(tree.GetSize());
        System.out.println(tree.GetMedian().GetKey());
        PrintTree(tree.InorderStart());
        PrintTree(tree.PreorderStart());
        PrintTree(tree.PostorderStart());
        
    }

    public static void PrintTree(String[] keys){
        for(int i=0;i<keys.length;i++){
            System.out.print(keys[i]+" ");
        }
        System.out.println();
    }

    public static BinarySearchTree<Student> TakeInput(){
        Map<String,InputHandler> cases=new HashMap<String,InputHandler>();
        cases.put("0", new FromFileHandler());

        System.out.print("choose if you want to insert from file or keyboard");
        System.out.print("0 for file");
        System.out.print("0 for keyboard");
        String input= "0";//new Scanner(System.in).nextLine();


        InputHandler handler = cases.get(input);
        if (handler != null) {
            return handler.GetInput();
        } else {
            return null;
        }
    }
}