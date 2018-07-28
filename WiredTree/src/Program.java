
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static ConsoleHandler ConsoleHandler;
    public static void main(String[] args)
    {
        Program.ConsoleHandler=new ConsoleHandler();
        BinarySearchTree<Student> tree = new BinarySearchTree<Student>();
        Program.InputCycle(tree);
    }

    public static void InputCycle(BinarySearchTree<Student> tree){
        String input= null;
        do{
        
            if(input!=null){
                Command command=Program.ConsoleHandler.getCommand(input);
                if(command==null){
                    System.out.println("Wrong option. try again.");        
                }else{
                    String result=command.runCommand(tree);
                    System.out.print(result);
                }
            }
            System.out.println("\nChoose option to do. Press 0 to exit.");
            System.out.println("Press 1 to get minimum");
            System.out.println("Press 2 to get maximum");
            System.out.println("Press 3 to get median");
            System.out.println("Press 4 to get size");
            System.out.println("Press 5 to get inorder view");
            System.out.println("Press 6 to get preorder view");
            System.out.println("Press 7 to get postorder view");
            System.out.println("Press 8 to insert node");
            System.out.println("Press 9 to search node and get its precessor and successor");
            System.out.println("Press 10 to delete node");
            System.out.println("Press 11 to insert nodes from file.");
            input= new Scanner(System.in).nextLine();
                
        }while(input!="0");
        System.out.println("Thank you and Goodbye!");
    }

    public static void PrintTree(String[] keys){
        for(int i=0;i<keys.length;i++){
            System.out.print(keys[i]+" ");
        }
        System.out.println();
    }

    // public static BinarySearchTree<Student> TakeInput(){
    //     Map<String,InputHandler> cases=new HashMap<String,InputHandler>();
    //     cases.put("0", new FromFileHandler());

    //     System.out.print("choose if you want to insert from file or keyboard");
    //     System.out.print("0 for file");
    //     System.out.print("0 for keyboard");
    //     String input= "0";//new Scanner(System.in).nextLine();


    //     InputHandler handler = cases.get(input);
    //     if (handler != null) {
    //         return handler.GetInput();
    //     } else {
    //         return null;
    //     }
    // }
}