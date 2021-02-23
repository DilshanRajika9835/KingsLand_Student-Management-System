package lk.kingsland.pos.bo;

import javafx.collections.ObservableList;
import lk.kingsland.pos.dto.CourseDTO;
import lk.kingsland.pos.dto.RegistrationDTO;
import lk.kingsland.pos.dto.StudentDTO;

import java.util.ArrayList;

public interface CourseBo {
    public boolean AddCourse(CourseDTO dto)throws Exception;
    public boolean updateCourse(CourseDTO dto)throws Exception;
    public boolean deleteCourse(String id)throws Exception;
    public CourseDTO getCourse(String id)throws Exception;
    public ObservableList<CourseDTO> getAllCourse()throws Exception;
}
