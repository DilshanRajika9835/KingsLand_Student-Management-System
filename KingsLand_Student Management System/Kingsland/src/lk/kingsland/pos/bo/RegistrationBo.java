package lk.kingsland.pos.bo;

import javafx.collections.ObservableList;
import lk.kingsland.pos.dto.RegistrationDTO;
import lk.kingsland.pos.dto.StudentDTO;
import lk.kingsland.pos.view.TM.CourseTM;

import java.util.ArrayList;

public interface RegistrationBo {
    public boolean RegStudent(RegistrationDTO dto)throws Exception;
    public boolean updateStudent(RegistrationDTO dto)throws Exception;
    public boolean deleteStudent(String id)throws Exception;
    public RegistrationDTO getStudent(String id)throws Exception;
    public ObservableList<RegistrationDTO> getRegAllStudent()throws Exception;
    public String getID(String id)throws Exception;
    public ObservableList<CourseTM>getregStudent(String ID)throws Exception;


}
