package br.com.fatec.firstProject.api.dto;

public class PaperDTO {
	
	private Long id;
	private String name;
	private String description;
	private GroupPaperDTO groupPaperDTO;
	
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
	
	public GroupPaperDTO getGroupPaperDTO() {
		return groupPaperDTO;
	}
	
	public void setGroupPaperDTO(GroupPaperDTO groupPaperDTO) {
		this.groupPaperDTO = groupPaperDTO;
	}

	@Override
	public String toString() {
		return "PaperDTO [id=" + this.id + ", name=" + this.name + "]";
	}
	
	
	
	
}
