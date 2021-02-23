package lk.kingsland.pos.bo;

import javafx.collections.ObservableList;
import lk.kingsland.pos.dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBo {
    public boolean saveStudent(StudentDTO dto)throws Exception;
    public boolean updateStudent(StudentDTO dto)throws Exception;
    public boolean deleteStudent(String id)throws Exception;
    public StudentDTO getStudent(String id)throws Exception;
    public ObservableList<StudentDTO> getAllStudent()throws Exception;
}
