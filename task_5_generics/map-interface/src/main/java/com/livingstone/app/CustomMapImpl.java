package com.livingstone.app;

import javafx.util.Pair;
import java.util.ArrayList;

public class CustomMapImpl<K, V> implements CustomMap<K, V>{
	private ArrayList< Pair<K,V> > table;
	private int capacity;
	
	//CONSTRUCTORS
	CustomMapImpl(){
		this.capacity = this.defaultSize;
		this.table = new ArrayList<>(this.capacity);
		for(int i=0;i<this.capacity;i+=1)
			this.table.add(new Pair<K,V>(null, null));
	}
	CustomMapImpl(int capacity){
		this.capacity = capacity;
		this.table = new ArrayList<>(this.capacity);
		for(int i=0;i<this.capacity;i+=1)
			this.table.add(new Pair<K,V>(null, null));
	}
	
	//CORE METHODS
	public int hashOfKey(K key){
		return key.hashCode()%this.capacity;
	}
	
	public void put(K key, V value){
		int hash = hashOfKey(key);
		table.set(hash, new Pair<K, V>(key, value));
	}
	
	public Pair<K, V> remove(K key){
		int hash = hashOfKey(key);
		Pair<K, V> removedPair= table.get(hash);
		
		if(removedPair.getKey()==null){
			
		}
			//throw error or tell user
			
		table.set(hash,  new Pair<K, V>(null, null));
		return removedPair;
	}
	
	public V get(K key){
		int hash = hashOfKey(key);
		return table.get(hash).getValue();
	}
	
	//GETTERS AND SETTERS
	public ArrayList<Pair<K, V>> getTable() {
		return table;
	}
	public void setTable(ArrayList<Pair<K, V>> table) {
		this.table = table;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	//DEMO TEST
	public static void main(String clargs[]){
		CustomMapImpl<String, Integer> map = new CustomMapImpl<String, Integer>();
		map.put("Hero", 7);
		map.put("Villian", 6);
		System.out.println(map.get("Hero"));//should give 7
		System.out.println(map.get("HeroX"));//should give null 
	}
}
