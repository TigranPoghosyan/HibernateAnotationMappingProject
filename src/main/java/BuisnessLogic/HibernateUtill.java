package BuisnessLogic;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtill {

        private static final SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory(){
            try {
                return new Configuration().configure().buildSessionFactory();
            }catch (Throwable ex){
                throw  new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory(){
            return sessionFactory;
    }

    public static void shutDown(){
            getSessionFactory().close();

        }
}
