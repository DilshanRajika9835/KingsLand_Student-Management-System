package lk.kingsland.pos.bo;

import lk.kingsland.pos.bo.custom.Impl.CourseBoImpl;
import lk.kingsland.pos.bo.custom.Impl.RegistrationBoImpl;
import lk.kingsland.pos.bo.custom.Impl.StudentBoImpl;

public  class BoFactory {
    private  static  BoFactory boFactory;
    private  BoFactory(){

    }
public  static  BoFactory getInstance(){
       return boFactory==null?boFactory=new BoFactory():boFactory;
}
public enum BOType {
    Student,Course,registration
    }
    public  <T>T getBO(BOType type){
        switch (type){
            case Course:return (T)new CourseBoImpl();
            case Student:return (T)new StudentBoImpl();
            case registration:return(T) new RegistrationBoImpl();
            default:return null;

        }
    }
}
