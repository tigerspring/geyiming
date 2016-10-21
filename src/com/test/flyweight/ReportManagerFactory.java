package com.test.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {
	
	Map<String,IReportManager> financialReportManager=new HashMap<String,IReportManager>();
	Map<String,IReportManager> empolyeeReportMananger=new HashMap<String,IReportManager>();
	
	IReportManager getFinancialReportManager(String tenantId) {
		IReportManager r = financialReportManager.get(tenantId);
		
		if(r == null){
			r = new FinancialReportManager(tenantId);
			financialReportManager.put(tenantId, r);
		}
		
		return r;
	}
	
	IReportManager getEmpolyeeReportMananger(String tenantId){
		IReportManager r = empolyeeReportMananger.get(tenantId);
		
		if(r == null){
			r = new EmpolyeeReportMananger(tenantId);
			empolyeeReportMananger.put(tenantId, r);
		}
		return r;
	}
}
