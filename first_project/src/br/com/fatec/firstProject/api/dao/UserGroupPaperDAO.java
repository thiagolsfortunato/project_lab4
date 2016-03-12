package br.com.fatec.firstProject.api.dao;

import java.util.List;

import br.com.fatec.firstProject.api.entity.GroupPaper;

public interface UserGroupPaperDAO {
	
	public void updateGroup(Long userId, List<GroupPaper> groups);

	public List<Long> searchGroups(Long userId);
}
