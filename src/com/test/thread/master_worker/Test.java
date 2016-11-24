package com.test.thread.master_worker;

import java.util.Map;
import java.util.Set;

import com.test.thread.master_worker.framework.Master;

public class Test {

	public static void main(String args[]){
		Master m = new Master(new PlusWork(),5);
		
		for(int i = 0 ; i < 30 ; i++)
			m.submit(i);
		m.execute();
		
		int re = 0 ; //最终计算结果保存在此
		
		Map<String,Object> resultMap = m.getResultMap();
		
		while(resultMap.size()>0 || !m.isComplete()){
			Set<String> keys = resultMap.keySet();
			String key = null;
			
			for(String k : keys){
				key = k;
				break;
			}
			Integer i = null;
			
			if(key!=null){
				i = (Integer) resultMap.get(key);
			}
			if(i != null){
				re += i;
			}
			if(key!=null){
				resultMap.remove(key);
			}
		}
		
		System.out.println(re);
	}
	
}
