package com.example.backend4402;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //this will be the route where we make HTTP requests.
public class Controller {
    private final MyService myService;
    @Autowired
    public Controller(MyService myService) {
        this.myService = myService;
    }

    //Example "Post" Api Call that executes a SQL statement (A String)
    @PostMapping("/sql")
    public List<Map<String, Object>> executeSQLStatement(@RequestBody Map<String, String> statement) {
        return myService.executeSql(statement.get("sql"));
    }

    //Example "Get" Api Call that returns if the backend is connected
    @GetMapping("/hello")
    public String sayHello() {
        return "Java Backend: Connected!\n";
    }

    // You will need to add additional API calls like the ones above to make
    // set, update, get , etc. statements that are relevant to your database.

    //adding students
    @PostMapping("/students")
    public String addStudent(@RequestBody Map<String, Object> student) {
        try {
            myService.addStudent(student);  
            return "it worked";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        try {
            myService.deleteStudent(id);  
            return "it worked";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
    
  

   
