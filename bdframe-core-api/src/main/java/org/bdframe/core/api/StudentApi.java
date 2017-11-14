package org.bdframe.core.api;

import java.util.List;

import org.bdframe.core.api.dto.StudentDTO;
/**
 * @author CocoLiu 2017
 * @version $Id AccountInfoApi.java$
 */
public interface StudentApi {
    List<StudentDTO> listStudents();
}
