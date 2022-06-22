package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import objects.Task;

 class TaskDAO implements DAO<Task> {
	public void insert(Task task) throws ClassNotFoundException, SQLException {
		DBConnector.getInstance();
		Connection conn = DBConnector.getConnection();
		String insert = "insert into tasks (user_name, task_title, task_description, group_name) values(?, ?, ?, ?)";
		PreparedStatement prepInsert = conn.prepareStatement(insert);
		prepInsert.setString(1, task.getInsert_un());
		prepInsert.setString(2, task.getTask_title());
		prepInsert.setString(3, task.getTask_description());
		prepInsert.setString(4, task.getGroup_name());
		prepInsert.execute();

	}

	public void select() throws ClassNotFoundException, SQLException {
		DBConnector.getInstance();
		Connection conn = DBConnector.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("select*from tasks");
		while (resultSet.next()) {
			Task task = new Task();
			task.setInsert_un(resultSet.getString(1));
			task.setTask_title(resultSet.getString(2));
			task.setTask_description(resultSet.getString(3));
			task.setGroup_name(resultSet.getString(4));
			System.out.println(task);

		}
	}

}
