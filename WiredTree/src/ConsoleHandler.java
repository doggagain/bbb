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
                BinaryNode<Student>[] nodes=tree.Search(new Student("",Integer.parseInt(id)));
                if(nodes==null){
                    return "node not found";
                }
                BinaryNode<Student> predecessor=nodes[1].GetPredecessor();
                BinaryNode<Student> successor=nodes[1].GetSuccessor();
                String predecessorString=predecessor==null? "none":predecessor.GetInfo().toString();
                String successorString=successor==null? "none":successor.GetInfo().toString();
              
                return "node is "+nodes[1].GetInfo().toString()
                        +"\n with predecessor: "+predecessorString
                        +"\n with successor: "+successorString;
            }
        });



        Cases.put("10",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                System.out.println("Enter id");
                String id= new Scanner(System.in).nextLine();
                Student info=tree.Delete(new Student("",Integer.parseInt(id)));
                if(info==null){
                    return "node not found";
                }
                return "deleted node is: "+info.toString();
            }
        });

        Cases.put("11",new Command(){
            @Override
            public String runCommand(BinarySearchTree<Student> tree) {
                String[] results=new FromFileHandler().GetInput(tree);
                return String.join("\n", results);
            }
        });
    }

    public Command getCommand(String option)
    {
        if(!this.Cases.containsKey(option)){
            return null;
        }
        return this.Cases.get(option);
    }
}