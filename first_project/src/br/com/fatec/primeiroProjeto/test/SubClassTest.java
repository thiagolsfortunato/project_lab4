package br.com.fatec.primeiroProjeto.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


//teste lists e new array lists
public class SubClassTest extends SuperClassTest {
	
	@Test
	public void sucesso(){
		System.out.println("1");
		Assert.assertTrue(1==1);
	}
	
	@Test
	public void falha(){
		System.out.println("2");
		Assert.assertTrue(1==2);
	}
	@Test
	public void erro(){
		System.out.println("3");
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.get(0);
	}
}
