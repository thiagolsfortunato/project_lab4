package br.com.fatec.firstProject.test;

import org.junit.Before;
import org.junit.BeforeClass;

public class SuperClassTest {

	@BeforeClass
	public static void beforeClass(){
		System.out.println("before class");
	}
	
	@Before
	public void setUp(){
		System.out.println("before");
	}
	
	//@AfterClass	
	//@After
}
