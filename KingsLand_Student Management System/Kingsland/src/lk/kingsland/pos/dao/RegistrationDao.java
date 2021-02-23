package lk.kingsland.pos.dao;

import javafx.collections.ObservableList;
import lk.kingsland.pos.entity.Registration;
import lk.kingsland.pos.entity.Student;
import lk.kingsland.pos.view.TM.CourseTM;

import java.util.ArrayList;

public interface RegistrationDao {
    public boolean save(Registration registration)throws Exception;
    public boolean updatet(Registration registration)throws Exception;
    public boolean delete(String id)throws Exception;
    public Registration  Search(String id)throws Exception;
    public ObservableList<Registration > getAll()throws Exception;
    public ObservableList<CourseTM> getregStudent(String ID) throws Exception;
}
