package com.livingstone.app;

import javafx.util.Pair;

public interface CustomMap<K, V> {
	public int defaultSize = 1000007;
	public void put(K key, V value);
	public Pair<K, V> remove(K key);
	public V get(K key);
	public String toString();
}
