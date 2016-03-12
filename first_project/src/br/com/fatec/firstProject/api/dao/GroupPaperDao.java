package br.com.fatec.firstProject.api.dao;

import java.util.List;

import br.com.fatec.firstProject.api.entity.GroupPaper;

public interface GroupPaperDao {

	Long save(GroupPaper groupPaper);
	
	void update(GroupPaper groupPaper);
	
	void delete(Long id);
	
	GroupPaper searchById(Long id);
	
	List<GroupPaper> searchAll();
	
	List<GroupPaper> searchByIds(List<Long> ids);
}
