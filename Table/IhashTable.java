package Table;

public interface IhashTable <Key,Value>{
	
	
	public Value getDataFromHashtable(Key key); 
	
	public void removeItemFromHashtable(Key key);

	public void putIntoHashtable(Key key, Value value); 
	
	public int SizeOfHashtable();
	
	

}
