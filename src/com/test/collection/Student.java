package com.test.collection;

public class Student implements Comparable<Student> {
	
	public String name;
	public int score;
	


	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * 当前元素this比其他元素o大时返回正序那么tremap为升序
	 * 反之treemap为降序
	 */
	public int compareTo(Student o) {
		if(o.score < this.score){
			return 1;//返回1代表 o 和this 按升序排序
		}else if(o.score > this.score){
			return -1;//返回-1代表 o 和this 按降序排序
		}
		return 0;//代表不用改变
	}
	
	public Student(String name,int score){
		this.name= name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("name:");
		sb.append(name);
		sb.append("	");
		sb.append("scroe:");
		sb.append(score);
		return sb.toString();
	}

}
