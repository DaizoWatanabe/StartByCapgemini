/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.google.common.primitives.Booleans;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.util.SimpleAnnotationValueVisitor14;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author daizo.watanabe
 */
public class TaskTableModel extends AbstractTableModel {

    //Definindo as colunas que teremos na table
    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};
    //Array dos dados da nossa table
    List<Task> tasks = new ArrayList();

    @Override
    public int getRowCount() {
        //Declara quantas linhas (tarefas) teremos no jTable de tarefas.
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        //Retorna a quantidade de colunas teremos na jTable de tarefas.
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return columnIndex == 3;

//        if (columnIndex == 3) {
//            return true;
//        } else {
//            return false;
//        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty()) {
            return Object.class;
        }

        //retorna a classe do conteúdo exibido na coluna, pois quando o jTable 
        //faz o draw no componente ele seta o componente com base no tipo de dado
        //no nosso caso, o tipo boolean será exibido com um checkbox
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //Retornando o dado da coluna 1 da tarefa da linha 1
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).isIsCompleted();
            case 4:
                return "";
            case 5:
                return "";

            default:
                return "Dados não encontrados";

        }
    }

    @Override
    //ao alterar o checkbox do row isCompleted, esse método recebe o valor
    //setado a row e a column como tipo objeto.
    //o método então faz um cast do objeto recebido para boolean
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setIsCompleted((boolean) aValue);
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
