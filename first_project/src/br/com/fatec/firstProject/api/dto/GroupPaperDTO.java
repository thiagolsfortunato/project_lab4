package br.com.fatec.firstProject.api.dto;

public class GroupPaperDTO {
	
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
	
	@Override
	public String toString() {
		return "GroupPaperDTO [id=" + this.id + ", name=" + this.name + "]";
	}
	
}
