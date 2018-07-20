
public class BinarySearchTree<T extends HaveKey> {
	private BinaryNode<T> Root;
	private int Size;
	private BinaryNode<T> Median;
	
	public BinaryNode<T> GetMedian(){
		return this.Median;
	}
	
	public BinaryNode<T> GetRoot(){
		return this.Root;
	}
	
	public void SetRoot(BinaryNode<T> root){
		this.Root=root;
	}
	
	public int GetSize(){
		return this.Size;
	}
	
	public void IncrementSize(){
		this.Size++;
	}
	
	public void DecrementSize(){
		this.Size--;
	}
	
	public void Insert(BinaryNode<T> node){
		BinaryNode<T> x= this.Root;
		
		if(x==null){
			this.Root=node;
			return;
		}
		
		while(!x.IsLeaf()){
			if(node.GetKey() < x.GetKey()){
				x=x.GetLeft();
			}else{
				x=x.GetRight();
			}
		}
		
		node.SetParent(x);
		if(node.GetKey() < x.GetKey()){
			node.SetLeft(x.GetLeft());
			x.SetLeft(node);
			node.SetRight(x);
		}else{
			node.SetRight(x.GetRight());
			x.SetRight(node);
			node.SetLeft(x);
		}
		this.UpdateMedianInsert(node);
		this.IncrementSize();
	}
	
	
	
	public BinaryNode<T> Delete(BinaryNode<T> node){
		BinaryNode<T> searchResult= this.Search(node.GetInfo());
		if(searchResult==null){
			return null;
		}
		this.UpdateMedianDelete(node);
		this.DecrementSize();
		
		BinaryNode<T> predecessor=searchResult.GetPredecessor();
		BinaryNode<T> successor=searchResult.GetSuccessor();
		
		ReassignPredecessorSuccessor(searchResult,predecessor,successor);
		
		BinaryNode<T> leafResult=ReassignIfLeaf(searchResult,predecessor,successor);
		if(leafResult!=null){
			return leafResult;
		}
		
		BinaryNode<T> twoChildrenResult=ReassignIfHasTwoChildren(searchResult,predecessor,successor);
		if(twoChildrenResult!=null){
			return twoChildrenResult;
		}
		
		return DeleteOneChild(searchResult);
		
	}
	
	public void ReassignPredecessorSuccessor(BinaryNode<T> searchResult,BinaryNode<T> predecessor,BinaryNode<T> successor){
		
		if( predecessor!=null && predecessor.GetRight()==searchResult){
			predecessor.SetRight(successor);
		}
		
		if( successor!=null && successor.GetLeft()==searchResult){
			successor.SetLeft(predecessor);
		}
	}
	
	public BinaryNode<T> ReassignIfLeaf(BinaryNode<T> searchResult,BinaryNode<T> predecessor,BinaryNode<T> successor){
		if(searchResult.IsLeaf()){
			
			if(searchResult.IsLeftChild()){
				
				searchResult.GetParent().SetLeft(predecessor);
				
			}else if(searchResult.IsRightChild()){
				
				searchResult.GetParent().SetRight(successor);
				
			}else{
				this.Root=null;
				return searchResult;
			}
			
		}
		return null;
	}
	
	public BinaryNode<T> ReassignIfHasTwoChildren(BinaryNode<T> searchResult,BinaryNode<T> predecessor,BinaryNode<T> successor){
		if(searchResult.IsParentOfLeft() && searchResult.IsParentOfRight()){
			
			BinaryNode<T> deleteResult=this.DeleteOneChild(successor);
			
			T info = searchResult.GetInfo();
			searchResult.SetInfo(deleteResult.GetInfo());
			deleteResult.SetInfo(info);
			return deleteResult;
		}
		return null;
	}
	
	public BinaryNode<T> DeleteOneChild(BinaryNode<T> node){
		
		if(node.GetParent()==null){
			if(node.IsParentOfRight()){
				this.Root=node.GetRight();
			}else{
				this.Root=node.GetLeft();
			}
		}
		
		if(node.IsLeftChild()){
			node.GetParent().SetLeft(node.GetLeft());
		}
		if(node.IsRightChild()){
			node.GetParent().SetRight(node.GetRight());
		}
		return node;
	}
	
	public void UpdateMedianInsert(BinaryNode<T> node){
		boolean isEven=this.Size %2 ==0;
		boolean isSmaller = node.GetKey() < this.Median.GetKey();
		
		if(isEven && isSmaller){
			this.Median=this.Median.GetPredecessor();
		}
		
		if(!(isEven || isSmaller)){
			this.Median=this.Median.GetSuccessor();
		}
	}
	
	public void UpdateMedianDelete(BinaryNode<T> node){
		boolean isEven=this.Size %2 ==0;
		boolean isSmaller = node.GetKey() < this.Median.GetKey();
		
		if(!isEven && isSmaller){
			this.Median=this.Median.GetSuccessor();
		}
		
		if(isEven && !isSmaller){
			this.Median=this.Median.GetPredecessor();
		}
	}
	
	public BinaryNode<T> GetMinimum(){
		return this.Root.GetMinium();
	}
	
	public BinaryNode<T> GetMaximum(){
		return this.Root.GetMaximum();
	}
	
	public  BinaryNode<T> GetPredecessor(BinaryNode<T> node){
		return node.GetPredecessor();
	}
	
	public  BinaryNode<T> GetSuccessor(BinaryNode<T> node){
		return node.GetSuccessor();
	}
	
	public BinaryNode<T> Search(T info){
		BinaryNode<T> current=this.Root;
		while(!current.IsLeaf() || current.GetKey()!=info.GetKey()){
			if(info.GetKey()< current.GetKey()){
				
				if(current.IsParentOfLeft()){
					current=current.GetLeft();
				}else{
					return null;
				}
				
			}else{
				
				if(current.IsParentOfRight()){
					current=current.GetRight();
				}else{
					return null;
				}
			}
		}
		if(current.GetKey()==info.GetKey()){
			return current;
		}
		return null;
	}
}
