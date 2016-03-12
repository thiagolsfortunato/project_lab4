package br.com.fatec.primeiroProjeto.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.primeiroProjeto.api.dao.UserDao;
import br.com.fatec.primeiroProjeto.api.entity.User;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.query.GeradorIdService;
import sun.security.krb5.Config;

public class UserDaoImpl implements UserDao {

	@Override
	public Long save(User user) {
		Connection conn = null;
		PreparedStatement insert = null;

		try {
			conn = ConfigDBMapper.getDefaultConnection();
			insert = conn.prepareStatement("INSERT INTO " + User.TABLE + " VALUES (?,?,?,?);");
			Long id = GeradorIdService.getNextId(User.TABLE);

			insert.setLong(1, id);
			insert.setString(2, user.getName());
			insert.setString(3, user.getLogin());
			insert.setString(4, user.getPassword());
			insert.execute();

			return id;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(insert);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public void update(User user) {
		Connection conn = null;
		PreparedStatement update = null;

		try {
			conn = ConfigDBMapper.getDefaultConnection();

			List<String> sets = Lists.newArrayList();
			sets.add(User.COL_NAME + " = : ?, ");
			sets.add(User.COL_LOGIN + " = : ?, ");
			sets.add(User.COL_PASSWORD + " = : ?, ");

			update = conn.prepareStatement("UPDATE " + User.TABLE + " SET " + sets + " WHERE " + User.COL_ID + " = ?;");

			update.setString(1, user.getName());
			update.setString(2, user.getLogin());
			update.setString(3, user.getPassword());
			update.setLong(4, user.getId());
			update.execute();

			return;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(update);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public void delete(Long id) {
		Connection conn = null;
		PreparedStatement delete = null;

		try {
			conn = ConfigDBMapper.getDefaultConnection();
			delete = conn.prepareStatement("DELETE FROM " + User.TABLE + " WHERE " + User.COL_ID + " = ?;");

			delete.setLong(1, id);
			delete.execute();

			return;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(delete);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public User findById(Long id) {
		Connection conn = null;
		PreparedStatement findById = null;
		User userReturn = null;

		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findById = conn.prepareStatement("SELECT * FROM " + User.TABLE + " WHERE " + User.COL_ID + " = ?;");
			findById.setLong(1, id);

			ResultSet result = findById.executeQuery();

			if (result.next()) {
				userReturn = new User(result.getLong(User.COL_ID), result.getString(User.COL_NAME),
						result.getString(User.COL_LOGIN), result.getString(User.COL_PASSWORD));
			}
			return userReturn;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(findById);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public List<User> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;

		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + User.TABLE);
			ResultSet result = findAll.executeQuery();

			return this.buildUsers(result);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(findAll);
			DbUtils.closeQuietly(conn);
		}
	}

	private List<User> buildUsers(ResultSet result) throws SQLException {
		List<User> users = Lists.newArrayList();
		while (result.next()) {
			users.add(this.buildUser(result));
		}
		return users;
	}

	private User buildUser(ResultSet result) throws SQLException {
		User user = new User();
		user.setId(result.getLong(User.COL_ID));
		user.setName(result.getString(User.COL_NAME));
		user.setLogin(result.getString(User.COL_LOGIN));
		user.setPassword(result.getString(User.COL_PASSWORD));

		return user;
	}

}
