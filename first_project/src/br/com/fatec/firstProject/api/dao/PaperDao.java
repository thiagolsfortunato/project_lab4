package br.com.fatec.firstProject.api.dao;

import java.util.List;

import br.com.fatec.firstProject.api.entity.Paper;

public interface PaperDao {
	Long save(Paper papel);

	void update(Paper papel);

	void delete(Long id);

	Paper findById(Long id);

	List<Paper> findAll();

	List<Paper> findByIds(List<Long> ids);

	List<Paper> findByGrupo(Long idGrupo);
}
