package com.tododao;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;    
import com.todomodel.Todo;    

public class TodoDAO {
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Todo t){  
		String sql= "INSERT INTO Tabletodo (task,description,date) VALUES ('"+t.getTask()+"','"+t.getDescription()+"','"+t.getDate()+"')";

	    return template.update(sql);    
	}    
	public int update(Todo t){  
		String sql = "UPDATE Tabletodo SET task = '"+t.getTask()+"', description ='"+t.getDescription()+"' ,date = '"+t.getDate()+"'  WHERE id = "+t.getId()+" ";

	    return template.update(sql);    
	}  
	public int delete(int id){    
	    String sql="delete from Tabletodo where id= "+id+" ";    
	    return template.update(sql);    
	}    
	public Todo getTodoById(int id) {
		String sql="select * from Tabletodo where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Todo>(Todo.class));    

	}
	            
			 
	    public List<Todo> getTodos(){ 
	    	
	    	    return template.query("select * from Tabletodo",new RowMapper<Todo>(){    
	    	        public Todo mapRow(ResultSet rs, int row) throws SQLException {    
	    	            Todo e=new Todo();    
	    	            e.setId(rs.getInt(1));    
	    	            e.setTask(rs.getString(2));    
	    	            e.setDescription(rs.getString(3));    
	    	            e.setDate(rs.getString(4));    
	    	            return e;    
	    	        }    
	    	    });    
	    	} 
	  	 
}
