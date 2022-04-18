/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author daizo.watanabe
 */
public class TaskController {

    //insert method
    public void save(Task task) {

        String sql = "INSERT INTO tasks ("
                + "idProject,"
                + "name,"
                + "description,"
                + "isCompleted,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES (?,?,?,?,?,?,?,?)";

        //precisa iniciliar com null, pois se declarar dentro do try o finally 
        //não consegue acessar
        Connection conn = null;
        //ajuda a preparar o comando sql que será executado no banco
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            //declara que quer alterar a primeira ? pelo valor informado
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);

        }

    }

    public void update(Task task) {

        String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?, isCompleted = ?, notes = ?, deadline = ?, createdAt = ?, updatedAt = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            //Estabelecendo a conexão com o BD
            conn = ConnectionFactory.getConnection();

            //Preparando a query
            statement = conn.prepareStatement(sql);

            //Setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());

            //Executando a query
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }

    }

    public void removeById(int taskId) {

        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            //Estabelecendo a conexão com o BD
            conn = ConnectionFactory.getConnection();

            //Preparando a query
            statement = conn.prepareStatement(sql);

            //Setando os valores
            statement.setInt(1, taskId);

            //Executando a query
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public List<Task> getAll(int idProject) {

        String sql = "SELECT * FROM tasks WHERE idProject = ?";

        Connection conn = null;
        PreparedStatement statement = null;
        //objeto que armazene a resposta do BD
        ResultSet resultSet = null;

        //Lista de tarefas que será devolvida quando a chamada do método
        //acontecer
        List<Task> tasks = new ArrayList<Task>();

        try {
            //Conexão e preparação
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            //Setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idProject);

            //Valor retornado pela execução da query
            resultSet = statement.executeQuery();

            //Enquanto houverem valores a serem percorridos no resultSet
            while (resultSet.next()) {

                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("isCompleted"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(new java.util.Date(resultSet.getDate("deadline").getTime()));
                task.setCreatedAt(new java.util.Date(resultSet.getDate("createdAt").getTime()));
                task.setUpdatedAt(new java.util.Date(resultSet.getDate("updatedAt").getTime()));

                tasks.add(task);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir as tarefas" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }

        //Lista de tarefas que foi criada e popularizada e carregada a partir 
        //dos dados obtidos na consulta ao BD
        return tasks;
    }

}
