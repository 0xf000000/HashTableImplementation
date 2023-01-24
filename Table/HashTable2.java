package Table;
import java.util.LinkedList;
public class HashTable2 <Key,Value> implements IhashTable<Key,Value> {
	
	private final int defaultSize = 16;
	private  LinkedList<TableEntry<Key,Value>>[] LinkedListArray;
	
	
	private void setLinkedListArray(LinkedList<TableEntry<Key,Value>>[] linkedList) {
		this.LinkedListArray = linkedList;
	}
	
	private LinkedList<TableEntry<Key,Value>>[] getLinkedListArray(){
		return this.LinkedListArray;
	}
	
	public HashTable2() {
		prepareArray(defaultSize);
		
	}
	
	public HashTable2(int size) {
		prepareArray(size);
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
		// TODO Auto-generated method stub
		int hashedKey = getHashedKey(key); 
		
		
		
		return getDataFromTableEntry(key,hashedKey);
	}
	
	
	private Value getDataFromTableEntry(Key key, int hashedKey) {
		
		LinkedList<TableEntry<Key,Value>> currentList = LinkedListArray[hashedKey];
		
		for(var entry : currentList) {if(key.hashCode() == entry.getKey().hashCode()) {  return entry.getValue(); }}
		
		return null;
		
	}

	@Override
	public void removeItemFromHashtable(Key key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putIntoHashtable(Key key, Value value) {
		
		int hashedKey = getHashedKey(key);
		
		putTableEntryIntoList(hashedKey,key, value);
	}
	
	
	private void putTableEntryIntoList(int hashedKey,Key key,Value value) {
		
		LinkedList<TableEntry<Key,Value>> currentList =  LinkedListArray[hashedKey];
		currentList.add(new TableEntry<Key,Value>(key,value));
	}
	
	
	private int getHashedKey(Key key) {
		return key.hashCode() % SizeOfHashtableArray();
	}

	
	private int SizeOfHashtableArray() {
		
		return LinkedListArray.length; 
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





	@Override
	public int SizeOfHashtable() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
