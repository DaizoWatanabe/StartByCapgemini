/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author daizo.watanabe
 */
public class TaskController {

    public void save(Task task) {

    }

    public void update(Task task) {

    }

    public void removeById(int taskId) throws SQLException {

        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null; //ajuda a preparar o comando sql que será executado no banco

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId); //declara que quer alterar a primeira ? pelo valor informado 
            statement.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao deletar a tarefa", ex);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    public List<Task> getAll(int idProject) {
        return null;
    }

}
