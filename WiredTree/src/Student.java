
public class Student extends HaveKey {
	private String Name;
	private int Id;
	
	public Student(String name,int id){
		this.Name=name;
		this.Id=id;
	}
	
	public String GetName(){
		return this.Name;
	}
	
	public int GetId(){
		return this.Id;
	}
	
	public void SetName(String name){
		this.Name=name;
	}
	
	public void SetId(int id){
		this.Id=id;
	}

	public int GetKey() {
		return this.GetId();
	}
}
