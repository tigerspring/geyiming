package com.test.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortTreeMap {

	public static void main(String args[]){
		TreeMap<Student,StudentDetailInfo> treeMap = new TreeMap<Student,StudentDetailInfo>();
		
		Student s1 = new Student("jinxuefeng",100);
		Student s2 = new Student("wangtengteng",99);
		Student s3 = new Student("liwei",80);
		Student s4 = new Student("xuemei",77);
		treeMap.put(s1, new StudentDetailInfo(s1));
		treeMap.put(s2, new StudentDetailInfo(s2));
		treeMap.put(s3, new StudentDetailInfo(s3));
		treeMap.put(s4, new StudentDetailInfo(s4));
		
		System.out.println(treeMap);
		/**
		 * 使用submap时首先看一定要保证fromkey<tokey ===>截取treemap区间为 s4到s2 不包括s2
		 */
		Map<Student,StudentDetailInfo> treeMap1 = (SortedMap<Student, StudentDetailInfo>) treeMap.subMap(s4,s2);
		
		for(Iterator<Student> itor = treeMap1.keySet().iterator() ; itor.hasNext() ;){
			Student s = itor.next();
			System.out.println(s +"	->	"+treeMap1.get(s));
		}
		
		
		//筛选出比liwei分数<的人
		System.out.println("===>筛选出比liwei分数低的人");
		treeMap1 = (SortedMap<Student, StudentDetailInfo>) treeMap.headMap(s3);
		
		for(Iterator<Student> itor = treeMap1.keySet().iterator() ; itor.hasNext() ;){
			Student s = itor.next();
			System.out.println(s +"	->	"+treeMap1.get(s));
		}
		
		//筛选出比liwei分数>=的人
		System.out.println("===>筛选出比liwei分数高于等于的人");
		treeMap1 = (SortedMap<Student, StudentDetailInfo>) treeMap.tailMap(s3);
		
		for(Iterator<Student> itor = treeMap1.keySet().iterator() ; itor.hasNext() ;){
			Student s = itor.next();
			System.out.println(s +"	->	"+treeMap1.get(s));
		}
		
		
		/*TreeMap<Integer,StudentDetailInfo> treeMap = new TreeMap<Integer,StudentDetailInfo>();*/
		/*treeMap.put(100, new StudentDetailInfo(s1));
		treeMap.put(80, new StudentDetailInfo(s2));
		treeMap.put(99, new StudentDetailInfo(s3));
		treeMap.put(77, new StudentDetailInfo(s4));*/
		
		/*SortedMap map1 = treeMap.subMap(70, 101);
		
		for(Iterator<Integer> itor = map1.keySet().iterator() ; itor.hasNext() ;){
			Integer s = itor.next();
			System.out.println("	->	"+treeMap.get(s));
		};*/
		
	}
}
