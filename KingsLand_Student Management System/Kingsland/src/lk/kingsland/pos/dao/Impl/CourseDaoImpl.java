package lk.kingsland.pos.dao.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.kingsland.pos.dao.CourseDao;
import lk.kingsland.pos.dao.CrudUtill;
import lk.kingsland.pos.dto.CourseDTO;
import lk.kingsland.pos.entity.Course;
import lk.kingsland.pos.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseDaoImpl implements CourseDao {

    @Override
    public boolean save(Course course) throws Exception {
      return   CrudUtill.execute("Insert Into Course values(?,?,?,?,?)",course.getCourseCode(),course.getCourseName(),course.getCourseType(),course.getDueration(),course.getRegFree());
    }

    @Override
    public boolean updatet(Course course) throws Exception {
        return   CrudUtill.execute("Update Course set Coursename=?,coursetype=?,Deuration=?,regFree=? where Coursecode=?",course.getCourseName(),course.getCourseType(),course.getDueration(),course.getRegFree(),course.getCourseCode());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtill.execute("Delete from Course Where CourseCode = ?",id);
    }

    @Override
    public Course Search(String id) throws Exception {
        ResultSet  rst = CrudUtill.execute("SELECT * from Course where courseCode=?", id);
        if(rst.next()){
        return   new Course(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5));
        }
        return null;
    }

    @Override
    public ObservableList<Course> getAll() throws Exception {
        ObservableList courselist= FXCollections.observableArrayList();
        ResultSet rst = CrudUtill.execute("SELECT * from Course");
        while (rst.next()){
            courselist.add( new Course(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));
        }
        return courselist;
    }
}
