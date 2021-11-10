package User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.Util;


public class UserDAO {
	public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<User> search(String name,String password) {
        Transaction transaction = null;
        List<User> users = null;
        Session session = Util.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User where identifiant ='"+name+"' and password ='"+password+"'");
            users = query.list();
            transaction.commit();
            session.close();
          return users;
        }
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<User> useradmin() {
        Transaction transaction = null;
        List<User> users = null;
        Session session = Util.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User");
            users = query.list();
            transaction.commit();
            session.close();
          return users;
        }
}
