package org.bdframe.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.bdframe.core.entity.Student;
import org.bdframe.core.service.StudentService;
import org.bdframe.core.service.mapper.StudentMapper;
import org.springframework.stereotype.Service;


@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentMapper studentMapper;
	
	@Override
	public List<Student> listStudent() {
		List<Student> listStudent = studentMapper.listStudent();
		return listStudent;
	}

}
