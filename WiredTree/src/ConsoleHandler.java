import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Command {
    String runCommand(BinarySearchTree<Student> tree);
}

public class ConsoleHandler{
    public Map<String,Command> Cases;
    
    public ConsoleHandler(){
        Cases=new HashMap<String,Command>();
        Cases.put("1",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                return tree.GetMinimum().GetInfo().toString();
            }
        });

        Cases.put("2",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                return tree.GetMaximum().GetInfo().toString();
            }
        });

        Cases.put("3",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                return tree.GetMedian().toString();
            }
        });

        Cases.put("4",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                return String.valueOf(tree.GetSize());
            }
        });

        Cases.put("5",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                return String.join(",",tree.InorderStart());
            }
        });


        Cases.put("6",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                return String.join(",",tree.PreorderStart());
            }
        });


        Cases.put("7",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                return String.join(",",tree.PostorderStart());
            }
        });


        Cases.put("8",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                System.out.println("Enter id");
                String id= new Scanner(System.in).nextLine();
                System.out.println("Enter name");
                String name= new Scanner(System.in).nextLine();
                Student student=new Student(name, Integer.parseInt(id));
                tree.Insert(student);
                return "inserted "+student.toString()+" successfully";
            }
        });


        Cases.put("9",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                System.out.println("Enter id");
                String id= new Scanner(System.in).nextLine();
                System.out.println("Enter name");
                String name= new Scanner(System.in).nextLine();
                Student student=new Student(name, Integer.parseInt(id));
                tree.Insert(student);
                return "inserted "+student.toString()+" successfully";
            }
        });
    }
}