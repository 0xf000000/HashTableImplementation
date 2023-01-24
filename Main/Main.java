package Main;

import Table.HashTable2;

public class Main {
	
	
	public static void main(String args[]) {
		HashTable2<String, Integer> table = new HashTable2<String,Integer>();
		table.putIntoHashtable("Hello", 2);
		table.putIntoHashtable("woooow cool", 100);
		int i  = table.getDataFromHashtable("Hello");
		int s = table.getDataFromHashtable("woooow cool");
		table.removeItemFromHashtable("Hello");
		System.out.print(i);
		System.out.println(s);
	}
	

}
