package com.Upgrade.SearchEngineParallelTests;

import org.testng.annotations.Test;
import basePackage.BaseClass;

public class TestClass extends BaseClass {
	
	@Test
	public void googleSearchTest() {
	System.out.println(getDriver().getTitle());
	System.out.println("Inside test 1=== "+Thread.currentThread().getId());
	}
	@Test
	public void SearchTest() {
		System.out.println(getDriver().getCurrentUrl());
		google.searchSomething("America");
		System.out.println("Inside test 2 "+Thread.currentThread().getId());

	}
	

}
