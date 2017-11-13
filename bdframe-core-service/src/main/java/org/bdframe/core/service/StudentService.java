package org.bdframe.core.service;

import java.util.List;

import org.bdframe.core.entity.Student;
import org.springframework.stereotype.Service;


@Service
public interface StudentService {

	List<Student> listStudent();
	
}
