package com.learning.todo.Todo_Manager.repository;

import com.learning.todo.Todo_Manager.helper.Helper;
import com.learning.todo.Todo_Manager.helper.TodoRowMapper;
import com.learning.todo.Todo_Manager.models.Todo;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


@Repository
public class TodoRepository {

@Autowired
    Helper helper;

    private JdbcTemplate template;

Logger logger = LoggerFactory.getLogger(TodoRepository.class);
    //Constructor
    public TodoRepository(@Autowired JdbcTemplate template) {
        this.template = template;
        // create table if not exist
        String createTable = "create table  IF NOT EXISTS todos(id INT PRIMARY KEY,title VARCHAR(100) NOT NULL,content VARCHAR(100),status VARCHAR(50) NOT NULL,addedDate DateTime,completeBefore Datetime)";
        template.execute(createTable);
        logger.info("Todos table is created");
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    Random random = new Random();
    // Add Todo in the database
    public Todo insert(Todo todo){
        int id = random.nextInt(100);
        if(todo.getId()==null) todo.setId(id);
        String insertQuery="insert into todos (id,title,content,status,addedDate,completeBefore) values (?,?,?,?,?,?)";
        int rows = template.update(insertQuery,todo.getId(),todo.getTitle(),todo.getContent(),
                     todo.getStatus(),todo.getAddedDate(),todo.getCompleteBefore());
        logger.info("Todo Added and Affected rows: {}",rows);
        return todo;
    }
    // List of all todos
    public List<Todo> fullList(){
        String query = "Select * from todos";
        List<Todo> list = template.query(query, new TodoRowMapper());

        return list;
    }

    //get single todo
    public Todo getSingle(int id){
        String query = "select * from todos where id =?";
        Todo todo = template.queryForObject(query,new TodoRowMapper(),id);

        logger.info("{}",todo);
        return todo;
    }

    //update table
    public Todo update(int id, Todo newtodo){
        StringBuilder query = new StringBuilder("update todos set " );// create query according to the update

        List<Object> list = new ArrayList<>();
        if(newtodo.getTitle()!=null){
            query.append("title = ?, ");
            list.add(newtodo.getTitle());
        }
        if(newtodo.getContent()!=null){
            query.append("content=?, ");
            list.add(newtodo.getContent());
        }
        if(newtodo.getStatus()!=null){
            query.append("status=?, ");
            list.add(newtodo.getStatus());
        }
        if(newtodo.getAddedDate()!=null){
            query.append("addedDate=?, ");
            list.add(newtodo.getAddedDate());
        }
        if(newtodo.getCompleteBefore()!=null){
            query.append("completeBefore=?, ");
            list.add(newtodo.getCompleteBefore());
        }
        query.setLength(query.length() - 2); // remove comma and space
        query.append(" where id = ?");
        list.add(id);
       logger.info(query.toString());
        template.update(query.toString(),list.toArray());
        logger.info("information is updated");
        return getSingle(id);
    }

    //delete a row
    public Boolean delete(int id){
        String query = "Delete from todos where id = ?";
        int row = template.update(query,id);
        logger.info("Todo has been deleted {}",row);
        return row == 1;
    }

    // delete multiple rows
    public void multiDelete(int...ids){
        String query = "Delete from todos where id =?";
        template.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                int id = ids[i];
                ps.setInt(1,id);
            }
            @Override
            public int getBatchSize() {
                return ids.length;
            }
        });
            logger.info("ids : {} has been deleted",helper.printArray(ids));
    }






}
