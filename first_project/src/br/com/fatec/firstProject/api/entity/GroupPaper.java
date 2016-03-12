package br.com.fatec.firstProject.api.entity;

public class GroupPaper {
	public static final String TABLE = "PROJ_GROUP_PAPER";
	public static final String COL_ID = "ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_DESCRIPTION = "DESCRIPTION";
	
	private Long id;
	private String nome;
	private String descricao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
