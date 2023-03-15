package dao;

import dados.SessionFac;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import transporte.CandidatoTO;
import transporte.QuestaoTO;
import transporte.QuestionarioTO;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ResponderDAO {
    public List<QuestaoTO> QuestaoList(int numeroqs){
        Transaction transaction = null;
        Vector<QuestaoTO> questaoTOVector = new Vector<>();

        Session session = SessionFac.getSessionFactory().openSession();
        transaction = (Transaction) session.beginTransaction();

        Query query = session.createQuery("from QuestaoTO");
        List<QuestaoTO> questaoList = ((org.hibernate.query.Query) query).list();
        List<QuestaoTO> apenasqs = new ArrayList<>();
        for(QuestaoTO d : questaoList){
            if(d.getQuestionario() == numeroqs){
                apenasqs.add(d);


            }
            

        }
        
        session.close();

        return apenasqs;
        
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

    public void cadastra(int acertos, int perguntas, String nome, int numeroqs){

        CandidatoTO candidatoTO = new CandidatoTO();
        Transaction transaction = null;
        try {
            Session session = SessionFac.getSessionFactory().openSession();
            transaction = (Transaction) session.beginTransaction();

            candidatoTO.setAcertos(acertos);
            Double nota = Double.valueOf(((acertos*100)/perguntas));

            candidatoTO.setNota(nota);
            candidatoTO.setNomecandi(nome);
            candidatoTO.setQuestionario(numeroqs);

            session.persist(candidatoTO);

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
