package br.com.fatec.firstProject.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class GroupPaper {
	public static final String TABLE = "PROJ_GROUP_PAPER";
	public static final String COL_ID = "ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_DESCRIPTION = "DESCRIPTION";
	
	private Long id;
	private String name;
	private String description;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static List<String> getColumns() {
		return Lists.newArrayList(COL_ID, COL_NAME, COL_DESCRIPTION);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NAME, COL_DESCRIPTION };
	}
	
}
