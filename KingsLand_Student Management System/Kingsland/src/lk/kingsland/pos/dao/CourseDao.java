package lk.kingsland.pos.dao;

import javafx.collections.ObservableList;
import lk.kingsland.pos.entity.Course;
import lk.kingsland.pos.entity.Student;

import java.util.ArrayList;

public interface CourseDao {
    public boolean save(Course course)throws Exception;
    public boolean updatet(Course course)throws Exception;
    public boolean delete(String id)throws Exception;
    public Course Search(String id)throws Exception;
    public ObservableList<Course> getAll()throws Exception;
}
