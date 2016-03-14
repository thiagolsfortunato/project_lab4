package br.com.fatec.firstProject.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.firstProject.api.dto.GroupPaperDTO;
import br.com.fatec.firstProject.api.entity.GroupPaper;
import br.com.spektro.minispring.dto.DTOConverter;

public class GroupPaperDTOConverter implements DTOConverter<GroupPaper, GroupPaperDTO> {

	@Override
	public GroupPaperDTO toDTO(GroupPaper groupPaper) {
		GroupPaperDTO groupPaperDTo = new GroupPaperDTO();
		groupPaperDTo.setId(groupPaper.getId());
		groupPaperDTo.setName(groupPaper.getName());
		groupPaperDTo.setDescription(groupPaper.getDescription());
		return groupPaperDTo;
	}

	@Override
	public GroupPaper toEntity(GroupPaperDTO groupPaperDTO) {
		GroupPaper groupPaper = new GroupPaper();
		groupPaper.setId(groupPaperDTO.getId());
		groupPaper.setName(groupPaperDTO.getName());
		groupPaper.setDescription(groupPaperDTO.getDescription());
		return groupPaper;
	}

	@Override
	public List<GroupPaperDTO> toDTO(List<GroupPaper> listGroupPaper) {
		List<GroupPaperDTO> listGroupPaperDTO = Lists.newArrayList();
		for (GroupPaper groupPaper : listGroupPaper) {
			listGroupPaperDTO.addAll(this.toDTO(listGroupPaper));
		}
		return listGroupPaperDTO;
	}
	
	@Override
	public List<GroupPaper> toEntity(List<GroupPaperDTO> listGroupPaperDTO) {
		List<GroupPaper> listGroupPaper = Lists.newArrayList();
		for(GroupPaperDTO groupPaperDTO : listGroupPaperDTO){
			listGroupPaper.add(this.toEntity(groupPaperDTO));
		}
		return listGroupPaper;
	}

}
