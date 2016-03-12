package br.com.fatec.firstProject.api.dao;

import java.util.List;
import br.com.fatec.firstProject.api.entity.Paper;

public interface UserPaperDAO {
	
	public void updatePapers(Long userId, List<Paper> papers);

	public List<Long> searchPapers(Long userId);
	
}
