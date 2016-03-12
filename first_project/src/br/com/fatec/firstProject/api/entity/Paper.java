package br.com.fatec.firstProject.api.entity;

public class Paper {
	public static final String TABLE = "PROJ_PAPER";
	public static final String COL_ID = "ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_DESCRIPTION = "DESCRIPTION";
	public static final String COL_GROUP_ID = "GROUP_PAPER_ID";
	
	private Long id;
	private String nome;
	private String descricao;
	private GroupPapel grupoPapelId;
	
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