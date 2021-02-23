package lk.kingsland.pos.dao;


import lk.kingsland.pos.bo.custom.Impl.RegistrationBoImpl;
import lk.kingsland.pos.bo.custom.Impl.StudentBoImpl;
import lk.kingsland.pos.dao.Impl.CourseDaoImpl;
import lk.kingsland.pos.dao.Impl.QueryDaoImpl;
import lk.kingsland.pos.dao.Impl.RegistrationDaoImpl;
import lk.kingsland.pos.dao.Impl.StudentDaoImpl;

public class DaoFactory {
   private static DaoFactory daoFactory;
   private DaoFactory() {

   }

   public static DaoFactory getInstance() {
      return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;

}
   public enum DaoType {
      Student, Course, registration,query;

   }

   public <T> T getDao(DaoType type) {
      switch (type) {
         case Course:
            return (T) new CourseDaoImpl();
         case Student:
            return (T) new StudentDaoImpl();
         case registration:
            return (T) new RegistrationDaoImpl();
         case query:return (T)new QueryDaoImpl();
         default:
            return null;

      }


   }
}

