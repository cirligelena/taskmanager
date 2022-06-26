package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import objects.Task;

 class TaskDAOImpl implements TaskDAO<Task> {
	 private static final Logger logger = LogManager.getLogger(DBConnector.class);
	public void insert(Task task) {
		DBConnector.getInstance();
		Connection conn = DBConnector.getConnection();
		String insert = "INSERT INTO tasks (user_id, task_title, task_description, group_name) values ((SELECT id FROM users WHERE user_name = '?'), '?', '?', '?')";
		PreparedStatement prepInsert;
		try {
			prepInsert = conn.prepareStatement(insert);
			prepInsert.setString(1, task.getUserName());
			prepInsert.setString(2, task.getTaskTitle());
			prepInsert.setString(3, task.getTaskDescription());
			prepInsert.setString(4, task.getGroupName());
			prepInsert.execute();
		} catch (SQLException e) {
			logger.error("Error while executing SQL statement ");
		}
	}

		public void select() {
			DBConnector.getInstance();
			Connection conn = DBConnector.getConnection();
			Statement statement;
			try {
				statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("select*from tasks");
				while (resultSet.next()) {
					Task task = new Task();
					task.setUserID(resultSet.getInt(1));
					task.setTaskTitle(resultSet.getString(2));
					task.setTaskDescription(resultSet.getString(3));
					task.setGroupName(resultSet.getString(4));
					System.out.println(task); 
				} 
				
			} catch (SQLException e) {
				logger.error("Error while executing SQL statement ");
			}
	}
}
