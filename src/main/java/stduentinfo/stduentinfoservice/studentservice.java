package stduentinfo.stduentinfoservice;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stduentinfo.stduentinfoentity.student;
import stduentinfo.stduentinforepository.studentRepository;

@Service
public class studentservice {
	
	@Autowired
	private studentRepository repository;
	
	public student addstudent(student student) {
		return repository.save(student);
	}
		
		public student getstudentById(int id) {
			return repository.findById(id).orElse(null);
		}
		
		public List<student> getAllstudents() {
			return repository.findAll();
		}
		
		public List<student> getAllstudentsAscendingOrder() {
			List<student> list = repository.findAll();
			
			list.sort(new Comparator<student>() {
				@Override
				public int compare(student o1, student o2) {
					return o1.getName().compareTo(o2.getName());
				}

			});

			return list;
		}
		
		public student editStudent(student student) {
			student ExistingStudent = repository.findById(student.getId()).orElse(null);
			ExistingStudent.setName(student.getName());
			ExistingStudent.setMarks(student.getMarks());
			return repository.save(ExistingStudent);
		}

		
		public String deleteStudent(int id) {
			repository.deleteById(id);
			return "student deleted";
		}
		}
		


