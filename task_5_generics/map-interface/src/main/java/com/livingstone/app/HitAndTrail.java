package com.livingstone.app;

import java.util.ArrayList;
import java.util.List;

public class HitAndTrail {
	public static void main(String []a){
		List<Integer> list = new ArrayList<Integer>(5);
		for(int i=0;i<4;i+=1)
			list.add(i*i);//set(i, i*i);
		for(int i=0;i<4;i+=1)
			System.out.println(list.get(i));
		
	}
}
