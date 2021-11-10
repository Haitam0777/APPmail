package Courier;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.Util;

public class ConsigneDAO {
	public void saveCon(Consigne con) {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(con);
        transaction.commit();
        session.close();
       
    }
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<String> listcon(int id) {
        Transaction transaction = null;
        List<String> Con = null;
        Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select consigne from Consigne where idmail ='"+id+"'");
            Con = query.list();
            transaction.commit();
            session.close();
          return Con;
        }
}
