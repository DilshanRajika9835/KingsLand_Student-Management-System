package lk.kingsland.pos.dao.Impl;

import javafx.collections.ObservableList;
import lk.kingsland.pos.dao.CrudUtill;
import lk.kingsland.pos.dao.StudentDao;
import lk.kingsland.pos.dto.StudentDTO;
import lk.kingsland.pos.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtill.execute("Insert Into Student values(?,?,?,?,?,?)",student.getStudentID(),student.getStudentName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtill.execute("Update  Student set StudentName=?,Address=?,Contact=?,Dob=?,Gender=? where StudentID=?",student.getStudentName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender(),student.getStudentID());
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtill.execute("Delete From Student Where StudentID=? ",id);
    }

    @Override
    public Student Search(String id) throws Exception {
        ResultSet rst = CrudUtill.execute("SELECT * from Student where StudentID=?", id);
        if(rst.next()){
        return new Student(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6));
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAll() throws Exception {
        ArrayList StudentList=new ArrayList();
        ResultSet rst = CrudUtill.execute("SELECT * from Student");
        while (rst.next()){
            StudentList.add (new Student(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6)));

        }
        return StudentList;
    }


}
