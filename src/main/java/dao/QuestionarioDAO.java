package dao;

import dados.SessionFac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import transporte.QuestionarioTO;

import java.sql.SQLException;

public class QuestionarioDAO {

    private static QuestionarioTO userObject;
    public QuestionarioDAO(){

    }
    public void insere(Object objeto) {
        QuestionarioTO depto = (QuestionarioTO) objeto;
        Transaction transaction = null;
        try {
            Session session = SessionFac.getSessionFactory().openSession();
            transaction = (Transaction) session.beginTransaction();

            userObject = new QuestionarioTO();



            System.out.println("Dados: " + objeto);

            session.persist(objeto);

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

    public void exclui(Object objeto){
        QuestionarioTO depto = (QuestionarioTO) objeto;
        Transaction transaction = null;
        try {
            Session session = SessionFac.getSessionFactory().openSession();
            transaction = (Transaction) session.beginTransaction();

            userObject = new QuestionarioTO();


            userObject.setIdquestionario(depto.getIdquestionario());
            userObject.setNome(depto.getNome());
            userObject.setTema(depto.getTema());

            System.out.println("Dados: " + objeto);

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
