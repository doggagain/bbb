public class BinaryParser {
    public BinarySearchTree<Student> ReadFile(String path){
        Student[] students=null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                students=ParseLine(line);
            }
        }

    } 

    private Student[] ParseLine(String line){
        String[] parts=line.split(";");
        Student[] students=new Student[parts.length];
        for (int i=0; i< parts.length; i++){
            students[i]=new Student(parts[i]);
        }
        return students;
    }

    private BinarySearchTree<Student> CreateTree(Student[] students){
        BinarySearchTree<Student> tree=new BinarySearchTree<Student>();

        for(int i=0;i<students.length;i++){
            tree.Insert(new Node)
        }
    }
}