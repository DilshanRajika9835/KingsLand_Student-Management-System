package lk.kingsland.pos.dao.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.kingsland.pos.dao.CrudUtill;
import lk.kingsland.pos.dao.RegistrationDao;
import lk.kingsland.pos.entity.Registration;
import lk.kingsland.pos.entity.Student;
import lk.kingsland.pos.view.TM.CourseTM;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RegistrationDaoImpl implements RegistrationDao {

    @Override
    public boolean save(Registration registration) throws Exception {
      return   CrudUtill.execute("Insert Into Registration Values(?,?,?,?,?)",registration.getRegNo(),registration.getRegDate(),registration.getStudentID(),registration.getCourseCode(),registration.getRegFree());
    }

    @Override
    public boolean updatet(Registration registration) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public Registration Search(String id) throws Exception {
    return null;
    }

    @Override
    public ObservableList<Registration> getAll() throws Exception {

        ResultSet rst = CrudUtill.execute("SELECT * from registration");
        ObservableList registerlist= FXCollections.observableArrayList();
        while (rst.next()){
          registerlist.add(new Registration(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));

        }
        return registerlist;
    }

    @Override
    public ObservableList<CourseTM> getregStudent(String id) throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT r.regNO,s.studentID,s.Contact,c.CourseCode,r.regFree from Student s,Course c,Registration r where r.CourseCode = ? &&s.studentID=r.studentID&&c.coursecode=r.coursecode;\n", id);
        ObservableList reglist=FXCollections.observableArrayList();
        while (rst.next()){
         reglist.add(new CourseTM(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getString(4),rst.getDouble(5)));
        }
    return reglist;
    }

}
