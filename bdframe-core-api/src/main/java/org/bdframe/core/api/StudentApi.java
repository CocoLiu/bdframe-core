package org.bdframe.core.api;

import java.util.List;

import org.bdframe.core.api.dto.StudentDTO;

public interface StudentApi {
    List<StudentDTO> listStudents();
}
