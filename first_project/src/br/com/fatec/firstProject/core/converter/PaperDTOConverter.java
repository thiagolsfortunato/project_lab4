package br.com.fatec.firstProject.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.firstProject.api.dto.PaperDTO;
import br.com.fatec.firstProject.api.entity.Paper;
import br.com.fatec.firstProject.api.entity.GroupPaper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;
import br.com.spektro.minispring.dto.DTOConverter;

public class PaperDTOConverter implements DTOConverter<Paper, PaperDTO> {

	private GroupPaperDTOConverter groupPaperDTOConverter;
	
	public PaperDTOConverter(){
		this.groupPaperDTOConverter = ImplFinder.getFinalImpl(GroupPaperDTOConverter.class);
	}
	
	@Override
	public PaperDTO toDTO(Paper paper) {
		PaperDTO paperDTO = this.toDTOSimple(paper);
		if(paper.getGrupoPaperId() != null){
			paperDTO.setGroupPaperDTO(this.groupPaperDTOConverter.toDTO(paper.getGrupoPaperId()));
		}
		return null;
	}
	
	public PaperDTO toDTOSimple(Paper paper){
		PaperDTO paperDTO = new PaperDTO();
		paperDTO.setId(paper.getId());
		paperDTO.setName(paper.getName());
		paperDTO.setDescription(paper.getDescricao());
		return paperDTO;
	}

	@Override
	public Paper toEntity(PaperDTO paperDTO) {
		Paper paper = new Paper();
		paper.setId(paperDTO.getId());
		paper.setName(paperDTO.getName());
		paper.setDescricao(paperDTO.getDescription());
		if(paperDTO.getGroupPaperDTO() != null){
			paper.setGrupoPaperId(new GroupPaper(paperDTO.getGroupPaperDTO().getId()));
		}
		return paper;
	}
		
	@Override
	public List<Paper> toEntity(List<PaperDTO> listPaperDTO) {
		List<Paper> listPaper = Lists.newArrayList();
		for(PaperDTO paperDTO : listPaperDTO){
			listPaper.add(this.toEntity(paperDTO));
		}
		return null;
	}
	
	@Override
	public List<PaperDTO> toDTO(List<Paper> listPaper) {
		return this.toDTO(listPaper, false);
	}
	
	public List<PaperDTO> toDTOSimple(List<Paper> listPaper){
		return this.toDTO(listPaper,true);
	}
	
	public List<PaperDTO> toDTO(List<Paper> listPaper, boolean simple) {
		List<PaperDTO> listPaperDTO = Lists.newArrayList();
		for(Paper paper: listPaper){
			listPaperDTO.add(simple ? this.toDTOSimple(paper) : this.toDTO(paper));
		}
		return listPaperDTO;
	}



}
