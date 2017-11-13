package org.bdframe.core.service.biz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bdframe.core.api.StudentApi;
import org.bdframe.core.api.dto.StudentDTO;
import org.bdframe.core.entity.Student;
import org.bdframe.core.service.StudentService;

import com.google.common.collect.Lists;

@Service("studentApi")
public class StudentBiz implements StudentApi{
	//private Logger logger = LoggerFactory.getLogger(StudentBiz.class);
	
	@Autowired
	private StudentService studentService;
	
	@Override
	public List<StudentDTO> listStudents() {
		List<Student> listStudent = studentService.listStudent();
		List<StudentDTO> listStudentDTO = Lists.newArrayList();
		for(Student student: listStudent){
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setId(student.getId());
			studentDTO.setAge(student.getAge());
			studentDTO.setName(student.getName());
			listStudentDTO.add(studentDTO);
		}
		return listStudentDTO;
	}

}
