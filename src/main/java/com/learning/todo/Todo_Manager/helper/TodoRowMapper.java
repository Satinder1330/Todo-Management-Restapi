package com.learning.todo.Todo_Manager.helper;

import com.learning.todo.Todo_Manager.models.Todo;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
         Todo todo = new Todo();
         todo.setId(rs.getInt("id"));
         todo.setTitle(rs.getString("title"));
         todo.setContent(rs.getString("content"));
         todo.setStatus(rs.getString("status"));
         todo.setAddedDate(rs.getDate("addedDate"));
         todo.setCompleteBefore(rs.getDate("completeBefore"));

        return todo;
    }
}
