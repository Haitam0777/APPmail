package Courier;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.Util;


public class CourierDAO {
	public void saveMail(Courier mail) {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(mail);
        transaction.commit();
        session.close();
       
    }
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Courier> mail(String name) {
        Transaction transaction = null;
        List<Courier> mail = null;
        Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Courier where destinat ='"+name+"'");
            mail = query.list();
            transaction.commit();
            session.close();
          return mail;
        }
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Courier> mailadmin(String name) {
        Transaction transaction = null;
        List<Courier> mail = null;
        Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Courier");
            mail = query.list();
            transaction.commit();
            session.close();
          return mail;
        }
}
