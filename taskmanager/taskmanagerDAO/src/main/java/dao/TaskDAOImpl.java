package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Task;

public class TaskDAOImpl extends DAOAbstract<Task> implements TaskDAO<Task> {

	@Override
	protected PreparedStatement getSelectAllStatement() throws SQLException {
		String query = "select * from tasks";
		PreparedStatement prepstatement = getDBConnection().prepareStatement(query);
		return prepstatement;
	}

	@Override
	protected PreparedStatement getInsertStatement(Task task) throws SQLException {
		String query = "INSERT INTO tasks (user_id, task_title, task_description, group_name) values ((SELECT id FROM users WHERE user_name = ?), ?, ?, ?)";
		PreparedStatement prepstatement = getDBConnection().prepareStatement(query);
		prepstatement.setString(1, task.getUserName());
		prepstatement.setString(2, task.getTaskTitle());
		prepstatement.setString(3, task.getTaskDescription());
		prepstatement.setString(4, task.getGroupName());

		return prepstatement;
	}

	@Override
	protected Task createObject(ResultSet resultSet) throws SQLException {
		Task task = new Task();
		task.setUserID(resultSet.getInt(1));
		task.setTaskTitle(resultSet.getString(2));
		task.setTaskDescription(resultSet.getString(3));
		task.setGroupName(resultSet.getString(4));
		return task;
	}
}
