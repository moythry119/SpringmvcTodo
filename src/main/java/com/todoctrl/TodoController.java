package com.todoctrl;
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;    
import com.todomodel.Todo;
import com.tododao.TodoDAO;
@Controller    
public class TodoController {
  @Autowired    
  TodoDAO dao;
  
  @RequestMapping("/todoform")    
  public String showform(Model m){    
      m.addAttribute("command", new Todo());  
      return "todoform";   
  }    
  @RequestMapping(value="/save",method = RequestMethod.POST)    
  public String save(@ModelAttribute("todo") Todo todo){    
      dao.save(todo);    
      return "redirect:/viewtodo";//will redirect to viewtodo request mapping    
  }    
  @RequestMapping("/viewtodo")    
  public String viewtodo(Model m){    
      List<Todo> list=dao.getTodos();    
      m.addAttribute("list",list);  
      return "viewtodo";    
  } 
  @RequestMapping(value="/editemp/{id}")    
  public String edit(@PathVariable int id, Model m){    
      Todo todo=dao.getTodoById(id);    
      m.addAttribute("command",todo);  
      return "todoeditform";    
  }    
  @RequestMapping(value="/editsave",method = RequestMethod.POST)    
  public String editsave(@ModelAttribute("todo") Todo todo){    
      dao.update(todo);    
      return "redirect:/viewtodo";    
  }    
  @RequestMapping(value="/deletetodo/{id}",method = RequestMethod.GET)    
  public String delete(@PathVariable int id){    
      dao.delete(id);    
      return "redirect:/viewtodo";    
  }   
}
