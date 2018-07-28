
import java.io.BufferedReader;
import java.io.FileReader;

public class BinaryParser {

    public String[] ReadFile(String path,BinarySearchTree<Student> tree){
        Student[] students=null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                students=ParseLine(line);
            }
        }catch(java.io.IOException e){
            System.out.println("could not load file.");
        }finally {
            // Will get executed, even if exception occurs
            System.out.println("Finished");
        }
        return CreateTree(students,tree);
    } 

    private Student[] ParseLine(String line){
        String[] parts=line.split(";");
        Student[] students=new Student[parts.length];
        for (int i=0; i< parts.length; i++){
            students[i]=new Student(parts[i]);
        }
        return students;
    }

    private String[] CreateTree(Student[] students,BinarySearchTree<Student> tree){
        String[] results=new String[students.length];
        for(int i=0;i<students.length;i++){
            tree.Insert(students[i]);
            results[i]="inserted node successfully: "+students[i].toString();
        }
        return results;
    }
}