package br.com.fatec.firstProject.api.dto;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class UserDTO {
	
	private Long id;
	private String name;
	private String login;
	private String password;
	private List<PaperDTO> papers = Lists.newArrayList();
	private List<GroupPaperDTO> groupsPaper = Lists.newArrayList();
	private Set<PaperDTO> paperCompiled = Sets.newHashSet();
	private Boolean isAdmin;
	
	public UserDTO(){}

	public UserDTO(Long id, String name, String login, String password) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
	};
	
	public boolean hasPaper(String paperName){
		for(PaperDTO paper: this.paperCompiled){
			if(paper.getName().equals(paperName)){
				return true;
			}
		}
		return false;
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

	public List<PaperDTO> getPapers() {
		return papers;
	}

	public void setPapers(List<PaperDTO> papers) {
		this.papers = papers;
	}

	public List<GroupPaperDTO> getGroupsPaper() {
		return groupsPaper;
	}

	public void setGroupsPaper(List<GroupPaperDTO> groupsPaper) {
		this.groupsPaper = groupsPaper;
	}

	public Set<PaperDTO> getPaperCompiled() {
		return paperCompiled;
	}

	public void setPaperCompiled(Set<PaperDTO> paperCompiled) {
		this.paperCompiled = paperCompiled;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + this.id + ", name=" + this.name + "]";
	}
	
	
}
