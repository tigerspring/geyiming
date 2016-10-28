package com.test.cache;

public class HeavyMethodDemo {

	public String heayMethod(int num){
		StringBuffer sb = new StringBuffer();
		String s=num+"=";//输出的字符串
		int smun=num;
		for(int i=2;i<=num;i++)//从2开始循环。
		{
		    if(smun%i==0)//判断是否整除
		    {
		    	smun=smun/i;//整除就将除后的值重新赋值
		    	if(smun==1)//如果赋值后的变量等于1，说明整除完毕。 
		    	{
		    		if(num/i==1)//如果原先输入的整数也能被这个数除完，说明只有一个分因式
		    		{
		    			s+=i+"*"+1;
		    			break;
		    		}
		    		s+=i;
		    		break;
		    	}
			    s+=i+"*";
			    i--;//数能被整除，却没有除完，从该数重新循环
		    }
		}
		return sb.append(s).toString();
	}
}
