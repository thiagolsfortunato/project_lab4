package br.com.fatec.firstProject.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class DAOUtils {

	public static String completeClauseValue(Class driverClass, int qtdParameters, String sequence) {
		String classname = driverClass.getName();
		StringBuilder clause = new StringBuilder();
		switch (classname) {
		case "org.hsqldb.jdbcDriver":
		case "org.postgresql.Driver":
			clause.append("nextval('" + sequence + "'),");
			break;
		case "oracle.jdbc.driver.OracleDriver":
			clause.append(sequence + ".nextVal,");
			break;
		case "com.mysql.jdbc.Driver":
			// do nothing
			break;
		}
		clause.append(StringUtils.repeat("?",", ", qtdParameters));
		return "(" + clause.toString() + ")";
	}
	
	public static String getColumns(Class dbClass, List<String> columsName){
		String classname = dbClass.getName();
		String columns = null;
		switch(classname){
		case "org.postgresql.Driver":
		case "oracle.jdbc.driver.OracleDriver":
			columns = StringUtils.join(columsName, ", ");
			break;
		case "com.mysql.jdbc.Driver":
			columsName = columsName.subList(1, columsName.size());
			columns = StringUtils.join(columsName, ", ");
			break;
		}
		return "(" + columns + ")";
	}
	
	public static PreparedStatement createStatment (String sql, Connection connection, Class dbClass, String[] colunas) throws SQLException {
		String classname = dbClass.getName();
		switch (classname) {
			case "org.postgresql.Driver":
			case "com.mysql.jdbc.Driver":
				return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			case "org.hsqldb.jdbcDriver":
			case "oracle.jdbc.driver.OracleDriver":
				return connection.prepareStatement(sql, colunas);
		}
		return null;		
	}
	
	public static String preparePlaceHolders(int length) {
		return StringUtils.join(Collections.nCopies(length, "?"), ",");
	}

	public static void setValues(PreparedStatement preparedStatement, List<Long> values) throws SQLException {
		for (int i = 0; i < values.size(); i++) {
			preparedStatement.setObject(i + 1, values.get(i));
		}
	}
}
