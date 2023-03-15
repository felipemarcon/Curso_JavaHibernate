package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dados.SessionFac;
import transporte.QuestaoTO;

public class CandidatoDAO {
	
	public void exclui(Object objeto) {

        Transaction transaction = null;
        try {
            Session session = SessionFac.getSessionFactory().openSession();
            transaction = (Transaction) session.beginTransaction();





            

            session.remove(objeto);

            // commit transaction
            transaction.commit();
            
            session.close();
        }
        catch(Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (IllegalStateException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }

    }

}
