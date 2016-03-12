package br.com.fatec.firstProject.test.commons;

import org.junit.BeforeClass;

import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ContextSpecifier;
import br.com.spektro.minispring.core.liquibaseRunner.LiquibaseRunnerService;

public class TestBase {
	
	@BeforeClass
	public static void setUp(){
		ContextSpecifier.setContext("br.com.fatec.primeiroProjeto"); //pacote base da minha aplicacao
		ConfigDBMapper.setDefaultConnectionName("test"); //configuração do banco de dados e coloca em memoria o bd
		LiquibaseRunnerService.run(); //acham meu arquivo e executa com a api do liquibase
	}
}
