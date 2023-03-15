package dao;

import dados.SessionFac;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import transporte.QuestaoTO;
import transporte.QuestionarioTO;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class QuestaoDAO {

    private static QuestaoTO userObject;
    public QuestaoDAO(){

    }

    public int VerificaQuestionario(String nome){
        DefaultTableModel dataModel=null;
int numero = 0;
        Transaction transaction = null;

        try {

            Session session = SessionFac.getSessionFactory().openSession();
            transaction = (Transaction) session.beginTransaction();

            Query query = session.createQuery("from QuestionarioTO");
            List<QuestionarioTO> deptoList = ((org.hibernate.query.Query) query).list();
            for(QuestionarioTO d : deptoList){
                if (d.getNome().equals(nome)){
                    numero = d.getIdquestionario();
                }

            }
            //Vector para os t�tulos das colunas

            //transaction.commit();
            session.close();
        }
        catch(Exception ee) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (IllegalStateException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            ee.printStackTrace();
        }
       return numero;
    }

    public void insere(Object objeto) {
        QuestaoTO depto = (QuestaoTO) objeto;
        Transaction transaction = null;
        try {
            Session session = SessionFac.getSessionFactory().openSession();
            transaction = (Transaction) session.beginTransaction();





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

    public void exclui(Object objeto) {
        QuestaoTO depto = (QuestaoTO) objeto;
        Transaction transaction = null;
        try {
            Session session = SessionFac.getSessionFactory().openSession();
            transaction = (Transaction) session.beginTransaction();





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
