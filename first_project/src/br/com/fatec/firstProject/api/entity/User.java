package br.com.fatec.firstProject.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class User {
	
	public static final String TABLE = "PROJ_USER";
	public static final String COL_ID = "ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_LOGIN = "LOGIN";
	public static final String COL_PASSWORD = "PASSWORD";
	
	private Long id;
	private String name;
	private String login;
	private String password;
	
	public User(){};
	
	public User(Long id, String nome, String login, String senha) {
		super();
		this.id = id;
		this.name = nome;
		this.login = login;
		this.password = senha;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public static List<String> getColumns() {
		return Lists.newArrayList(COL_ID, COL_NAME, COL_LOGIN, COL_PASSWORD);
	}

	public static String[] getColumnsArray() {
		return new String[] {COL_ID, COL_NAME, COL_LOGIN, COL_PASSWORD};
	}
	
}
