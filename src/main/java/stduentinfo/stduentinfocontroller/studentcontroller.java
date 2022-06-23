package stduentinfo.stduentinfocontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import stduentinfo.stduentinfoentity.student;
import stduentinfo.stduentinfoservice.studentservice;

@RestController
public class studentcontroller {
@Autowired
	private studentservice service;
	
	@GetMapping("/students/{id}")
	public student getStudentById(@PathVariable int id) {
		return service.getstudentById(id);		
	}
	
	@GetMapping("/students")
	public List<student> getStudents(){
		return service.getAllstudents();
	}
	
	@GetMapping("/studentsbyascendingorder")
	public List<student> getStudentsByAscendingOrder(){
		return service.getAllstudentsAscendingOrder();
	}
	
	@PostMapping("/addstudents")
	public student saveStudent(@RequestBody student student) {	
		return service.addstudent(student);	
	}
	
	@PutMapping("/students")
	public student editStudent(@RequestBody student student) {
		return service.editStudent(student);
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
	}

