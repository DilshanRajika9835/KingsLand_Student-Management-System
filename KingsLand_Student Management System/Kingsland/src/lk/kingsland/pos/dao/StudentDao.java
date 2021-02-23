package lk.kingsland.pos.dao;

import lk.kingsland.pos.entity.Student;

import java.util.ArrayList;

public interface StudentDao {
    public boolean save(Student student)throws Exception;
    public boolean update(Student student)throws Exception;
    public boolean delete(String id)throws Exception;
    public Student Search (String id)throws Exception;
    public ArrayList<Student> getAll()throws Exception;
}
