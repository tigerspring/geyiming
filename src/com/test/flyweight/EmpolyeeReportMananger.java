package com.test.flyweight;

public class EmpolyeeReportMananger implements IReportManager{

	protected String tenantId = null;
	
	public EmpolyeeReportMananger(String tenantId) {
		this.tenantId = tenantId;
	}
	

	@Override
	public String createReport() {
		return "this is empolyee report";
	}

}
