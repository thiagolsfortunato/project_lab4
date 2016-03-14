package br.com.fatec.firstProject.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.firstProject.api.dao.GroupPaperDao;
import br.com.fatec.firstProject.api.entity.GroupPaper;
import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class GroupPaperDAOImpl implements GroupPaperDao{

	@Override
	public Long save(GroupPaper groupPaper) {
		Connection connection = null;
		PreparedStatement insert = null;
		try{
			connection = ConfigDBMapper.getDefaultConnection();
			String columns = DAOUtils.getColumns(getDefaultConnectionType(), GroupPaper.getColumns());
			String values = DAOUtils.completeClauseValue(getDefaultConnectionType(), 2, "SEQ_PROJ_GROUP_PAPER");
			
			String sql = "INSERT INTO " + GroupPaper.TABLE + columns + " VALUES " + values;
			
			insert = DAOUtils.createStatment(sql, connection, getDefaultConnectionType(), GroupPaper.getColunasArray());
			
			insert.setString(1, groupPaper.getName());
			insert.setString(2, groupPaper.getDescription());
			insert.executeUpdate();
			
			ResultSet generateKeys = insert.getGeneratedKeys();
			if(generateKeys.next()){
				return generateKeys.getLong(1);
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(insert);
			DbUtils.closeQuietly(connection);
		}		
	}

	@Override
	public void update(GroupPaper groupPaper) {
		Connection connection = null;
		PreparedStatement update = null;
		try{
			connection = ConfigDBMapper.getDefaultConnection();
			update = connection.prepareStatement("UPDATE" + GroupPaper.TABLE + " SET " + GroupPaper.COL_NAME + " = ?," + GroupPaper.COL_DESCRIPTION + " = ? WHERE "+ GroupPaper.COL_ID + " = ?");
			update.setString(1, groupPaper.getName());
			update.setString(2,groupPaper.getDescription());
			update.setLong(3, groupPaper.getId());
			update.executeUpdate();
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(connection);
			DbUtils.closeQuietly(update);
		}
	}

	@Override
	public void delete(Long id) {
		Connection connection = null;
		PreparedStatement delete = null;
		try{
			connection = ConfigDBMapper.getDefaultConnection();
			String sql = "DELETE FROM " + GroupPaper.TABLE +  " WHERE ID = ?";
			delete = connection.prepareStatement(sql);
			delete.setLong(1, id);
			delete.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			DbUtils.closeQuietly(connection);
			DbUtils.closeQuietly(delete);
		}
	}

	@Override
	public GroupPaper searchById(Long id) {
		Connection connection = null;
		PreparedStatement findById = null;
		GroupPaper groupPaper = null;
		try{
			connection = ConfigDBMapper.getDefaultConnection();
			String query = "SELECT * FROM "+ GroupPaper.TABLE + " WHERE " + GroupPaper.COL_ID + " = ?";
			findById = connection.prepareStatement(query);
			findById.setLong(1, id);
			ResultSet resultSet = findById.executeQuery();
			if(resultSet.next()){
				groupPaper = this.buildGroupPaper(resultSet);
			}
			return groupPaper;
		}catch(Exception e ){
			throw new RuntimeException(e);
		}finally{
			DbUtils.closeQuietly(connection);
			DbUtils.closeQuietly(findById);
		}
	}

	@Override
	public List<GroupPaper> searchAll() {
		Connection connection = null;
		PreparedStatement searchAll = null;
		try{
			connection = ConfigDBMapper.getDefaultConnection();
			searchAll = connection.prepareStatement("SELECT * FROM " + GroupPaper.TABLE);
			ResultSet resultSet = searchAll.executeQuery();
			return this.buildGroupPapers(resultSet);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			DbUtils.closeQuietly(connection);
			DbUtils.closeQuietly(searchAll);
		}
	}

	@Override
	public List<GroupPaper> searchByIds(List<Long> groupPaperIds) {
		List<GroupPaper> groupPapers = Lists.newArrayList();
		if(groupPaperIds.size() > 0){
			Connection connection = null;
			PreparedStatement searchByIds = null;
			try{
				connection = ConfigDBMapper.getDefaultConnection();
				String arguments = DAOUtils.preparePlaceHolders(groupPaperIds.size());
				String query = "SELECT * FROM "+ GroupPaper.TABLE +" WHERE " + GroupPaper.COL_ID + " IN (" + arguments + ")";
				searchByIds = connection.prepareStatement(query);
				DAOUtils.setValues(searchByIds, groupPaperIds);
				ResultSet resultSet = searchByIds.executeQuery();
				groupPapers = this.buildGroupPapers(resultSet);
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				DbUtils.closeQuietly(connection);
				DbUtils.closeQuietly(searchByIds);
			}
		}
		return groupPapers;
	}
	
	private List<GroupPaper> buildGroupPapers(ResultSet resultSet) throws SQLException{
		List<GroupPaper> groupPaper = Lists.newArrayList();
		while(resultSet.next()){
			groupPaper.add(this.buildGroupPaper(resultSet));
		}
		return groupPaper;
	}
	
	private GroupPaper buildGroupPaper(ResultSet resultSet) throws SQLException{
		GroupPaper groupPaper = new GroupPaper();
		groupPaper.setId(resultSet.getLong(GroupPaper.COL_ID));
		groupPaper.setName(resultSet.getString(GroupPaper.COL_NAME));
		groupPaper.setDescription(resultSet.getString(GroupPaper.COL_DESCRIPTION));
		return groupPaper;
	}	
}
