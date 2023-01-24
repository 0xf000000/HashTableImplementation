package Table;
import java.util.LinkedList;
public class HashTable2 <Key,Value> implements IhashTable<Key,Value> {
	
	private final int defaultSize = 16;
	private  LinkedList<TableEntry<Key,Value>>[] LinkedListArray;
	
	public HashTable2() {
		prepareArray(defaultSize);
		
	}
	
	public HashTable2(int size) {
		prepareArray(size);
	}
	
	
	private void setLinkedListArray(LinkedList<TableEntry<Key,Value>>[] linkedList) {
		this.LinkedListArray = linkedList;
	}
	
	private LinkedList<TableEntry<Key,Value>>[] getLinkedListArray(){
		return this.LinkedListArray;
	}
	
	
	
	private int getHashedKey(Key key) {
		return hashFunction(key) % SizeOfHashtableArray();
	}
	
	
	public int hashFunction(Key key) {
		
		return key.hashCode();
	}
	
	
	
	
	private void prepareArray(int size) {
		
		checkIfarraySizeIsValid(size);
		fillArray();
	}
	
	
	private void fillArray() {
		for(int i = 0 ; LinkedListArray.length > i; i++) {
			LinkedListArray[i] = new LinkedList<TableEntry<Key,Value>>();
		}
	}
	
	private void checkIfarraySizeIsValid(int size) {
		
		if(size <= 1){setLinkedListArray(new LinkedList[defaultSize]);}
		else {setLinkedListArray(new LinkedList[size]);}
	}
	
	
	@Override
	public Value getDataFromHashtable(Key key) {
		
		int hashedKey = getHashedKey(key); 
		
		TableEntry<Key,Value> tableEntry = getTableEntry(key,hashedKey);
		
		if(checkIfTableEntryIsNull(tableEntry)) { return null;} 
		
		return tableEntry.getValue();
	}
	
	
	private boolean checkIfTableEntryIsNull(TableEntry<Key,Value> tableEntry){
		return tableEntry == null;
	}
	
	
	private TableEntry<Key,Value> getTableEntry(Key key, int hashedKey) {
		
		LinkedList<TableEntry<Key,Value>> currentList = LinkedListArray[hashedKey];
		
		for(var entry : currentList) {
			if(key.hashCode() == entry.getKey().hashCode()) {  return entry; }
			}
		
		return null;
	}
	

	@Override
	public void removeItemFromHashtable(Key key) {
		int hashedKey = this.getHashedKey(key);
		
		TableEntry<Key,Value> tableEntry = getTableEntry(key, hashedKey);
		

	}

	@Override
	public void putIntoHashtable(Key key, Value value) {
		
		int hashedKey = getHashedKey(key);
		
		LinkedList<TableEntry<Key,Value>> currentList =  LinkedListArray[hashedKey];
		currentList.add(new TableEntry<Key,Value>(key,value));
	}
	
	
	

	
	private int SizeOfHashtableArray() {
		
		return LinkedListArray.length; 
	}
	
	@Override
	public int SizeOfHashtable() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	private class TableEntry<Key,Value>{
		
		private Key key; 
		private Value value;
		
		public TableEntry(Key key, Value value) {
			this.key = key; 
			this.value = value; 
		}
		
		public Key getKey() {
			return key;
		}
		
		public Value getValue() {
			return value;
		}
	}



	
}
