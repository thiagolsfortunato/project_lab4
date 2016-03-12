package br.com.fatec.firstProject.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Paper {
	public static final String TABLE = "PROJ_PAPER";
	public static final String COL_ID = "ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_DESCRIPTION = "DESCRIPTION";
	public static final String COL_GROUP_ID = "GROUP_PAPER_ID";
	
	private Long id;
	private String name;
	private String description;
	private GroupPaper grupoPaperId;
		
	public Paper(Long id, String name, String description, GroupPaper grupoPaperId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.grupoPaperId = grupoPaperId;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescricao() {
		return description;
	}
	
	public void setDescricao(String descricao) {
		this.description = descricao;
	}
	
	public static List<String> getColumns() {
		return Lists.newArrayList(COL_ID, COL_NAME, COL_DESCRIPTION, COL_GROUP_ID);
	}

	public static String[] getColuMnsArray() {
		return new String[] {COL_ID, COL_NAME, COL_DESCRIPTION, COL_GROUP_ID};
	}
	
}
