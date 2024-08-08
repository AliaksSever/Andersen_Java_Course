package service;
import storage.CustomArrayList;
import storage.CustomHashSet;

public class StorageService {
	
	public static void main(String[] args) {
		
		CustomArrayList<String> customArrayList = new CustomArrayList<>();
		System.out.println(customArrayList);
		customArrayList.put("Apple");
		customArrayList.put("Microsoft");
		customArrayList.put("Apple");
		System.out.println(customArrayList);
		customArrayList.delete(2);
		System.out.println(customArrayList);
		System.out.println(customArrayList.get(0));

		System.out.println();
		
		CustomHashSet<String> mySet = new CustomHashSet<>();
		mySet.put("Aa");
		mySet.put("BB");
		mySet.put(null);
		mySet.put("String1");
		mySet.put("String2");
		mySet.put(null);
		mySet.put("String1");
		mySet.delete(null);
		mySet.put("String3");
		
		for (String el: mySet) {
			System.out.println(el);
		}
		
	}

}
