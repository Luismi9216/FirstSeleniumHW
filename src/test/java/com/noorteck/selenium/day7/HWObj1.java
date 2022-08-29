package com.noorteck.selenium.day7;

public class HWObj1 {
	public static void main(String[] args) throws InterruptedException {

		Homework1 obj = new Homework1();

		obj.setUp();
		
//	    obj.doubleClickTest();
//	   
//		obj.rightClickTest();
//		obj.dragAndDrop();
//
//		obj.dynamicClickTest();
//		
		obj.addNewJob();
		
		obj.tearDown();
	}
}
