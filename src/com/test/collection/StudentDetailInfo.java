package com.test.collection;

public class StudentDetailInfo {

	Student s;
	public StudentDetailInfo(Student s){
		this.s = s;
	}
	
	@Override
	public String toString() {
		return s.name +"'s detail information";
	}
}
