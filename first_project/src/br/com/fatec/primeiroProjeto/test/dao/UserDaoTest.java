package br.com.fatec.primeiroProjeto.test.dao;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.primeiroProjeto.api.dao.UserDao;
import br.com.fatec.primeiroProjeto.api.entity.User;
import br.com.fatec.primeiroProjeto.test.commons.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;


public class UserDaoTest extends TestBase{
	
	private UserDao dao;
	
	@Before
	public void config(){
		//implFinder sobe até o pacote br.com.fatec cria o .core e procura por alguem que implementa essa interface
		this.dao = ImplFinder.getImpl(UserDao.class);
	}
	
	@Test
	public void save(){
		User user = new User(null,"Thiago","thiagolsfortunato","1234");
		
		Long idSalved = this.dao.save(user);
		User userSaved = this.dao.findById(idSalved);
		
		Assert.assertEquals("Thiago", userSaved.getName());
		Assert.assertEquals("thiagolsfortunato", userSaved.getLogin());
		Assert.assertEquals("1234", userSaved.getPassword());
	}
	
	@Test
	public void update(){
		User user = new User(null,"Thiago","thiagolsfortunato","1234");
		
		Long idSalved = this.dao.save(user);
		User userSaved = this.dao.findById(idSalved);
		
		userSaved.setName("Thiago Fortunato");
		userSaved.setLogin("ThiagoFortunato");
		userSaved.setPassword("4321");
		
		this.dao.update(userSaved);
		User userUpdate = this.dao.findById(idSalved);
		
		Assert.assertEquals("Thiago Fortunato", userUpdate.getName());
		Assert.assertEquals("ThiagoFortunato", userUpdate.getLogin());
		Assert.assertEquals("4321", userUpdate.getPassword());
		
	}
	
	@Test
	public void delete(){
		User user = new User(null,"Thiago","thiagolsfortunato","1234");
		
		Long idSalved = this.dao.save(user);
		this.dao.delete(idSalved);
		
		User userDeleted = this.dao.findById(idSalved);
		
		Assert.assertNull(userDeleted);
	}
	
	@Test
	public void findAll(){
		User user1 = new User(null,"Thiago","thiagolsfortunato","1234");
		User user2 = new User(null,"Pedro","pedroaluno","1111");
		User user3 = new User(null,"Joao","joaoaluno","2222");
		
		this.dao.save(user1);
		this.dao.save(user2);
		this.dao.save(user3);
		
		List<User> listUsers = this.dao.findAll();
				
		Assert.assertEquals(3, listUsers.size());
		
		Assert.assertEquals("Thiago", listUsers.get(0).getName());
		Assert.assertEquals("thiagolsfortunato", listUsers.get(0).getLogin());
		Assert.assertEquals("1234", listUsers.get(0).getPassword());
		
		Assert.assertEquals("Pedro", listUsers.get(1).getName());
		Assert.assertEquals("pedroaluno", listUsers.get(1).getLogin());
		Assert.assertEquals("1111", listUsers.get(1).getPassword());
		
		Assert.assertEquals("Joao", listUsers.get(2).getName());
		Assert.assertEquals("joaoaluno", listUsers.get(2).getLogin());
		Assert.assertEquals("2222", listUsers.get(2).getPassword());
		
	}
	
	@Test
	public void findById(Long id){
		User user1 = new User(null,"Thiago","thiagolsfortunato","1234");
		User user2 = new User(null,"Pedro","pedroaluno","1111");
		
		Long id1 = this.dao.save(user1);
		Long id2 = this.dao.save(user2);
		
		User userSaved = this.dao.findById(id2);
		
		Long idSalvo = this.dao.save(user1);
		//User userSaved = this.dao.findById(idSalvo);		
	}
}	
