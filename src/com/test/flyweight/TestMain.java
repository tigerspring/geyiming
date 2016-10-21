package com.test.flyweight;

public class TestMain {

	public static void main(String[] args) {
		ReportManagerFactory reportManagerFactory = new ReportManagerFactory();
		IReportManager iReportManager = reportManagerFactory.getEmpolyeeReportMananger("a");
		System.out.println(iReportManager.createReport());
	}
}
