package br.com.fatec.firstProject.api.service;

import java.util.List;
import br.com.fatec.firstProject.api.dto.PaperDTO;

public interface PaperService {
	
	PaperDTO save(PaperDTO paper);
	
	PaperDTO update(PaperDTO paper);
	
	void delete(Long paperId);
	
	List<PaperDTO> list();
	
	PaperDTO searchById(Long paperId);
}
