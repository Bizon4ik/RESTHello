package hello.DAOs;

import hello.Models.Contacts;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class RESTHelloDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public RESTHelloDAO(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public void savePreliminaryContacts(List<Contacts> contactsList){
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();

            for (int i = 0 ; i < contactsList.size(); i++) {
                System.out.println("i = " + i);
                session.save(contactsList.get(i));
                if ( i % 20 == 0 ) {
                    session.flush();
                    session.clear();
                }
            }

            tx.commit();
        }finally {
            session.close();
        }

    }

    public List<Contacts> getAllContacts(){
        Session session = sessionFactory.openSession();
        List<Contacts> contactsList = null;
        try{
            Criteria criteria = session.createCriteria(Contacts.class);
            contactsList =  criteria.list();

        }finally {
            session.close();
        }

        return contactsList;
    }

}
