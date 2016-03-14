package br.com.fatec.firstProject.api.service;

import java.util.List;
import br.com.fatec.firstProject.api.dto.GroupPaperDTO;

public interface GroupPaperService {
	
	GroupPaperDTO save(GroupPaperDTO groupPaper);
	
	GroupPaperDTO update(GroupPaperDTO groupPaper);
	
	void delete(Long groupPaperId);
	
	List<GroupPaperDTO> list();
	
	GroupPaperDTO searchById(GroupPaperDTO grouPaperId);
}
