package controller;

import dados.SessionFac;
import dao.QuestionarioModel;
import dao.ResponderDAO;
import dao.ResponderModel;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import transporte.CandidatoTO;
import transporte.QuestaoTO;
import view.QuestionarioFRM;
import view.ResponderFRM;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class ResponderController {
    ResponderFRM responderFRM;
    ResponderModel responderModel;
    ResponderDAO responderDAO;
    CandidatoTO candidatoTO;

    public ResponderController(ResponderFRM responderFRM, ResponderModel responderModel){
        this.responderFRM = responderFRM;
        this.responderModel = responderModel;
        this.responderFRM.addContinuarListener(new ResponderController.ResponderContinuarListener());
        this.responderFRM.addProximaListener(new ResponderController.ResponderProximaListener());
    }

    class ResponderProximaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("aa");
            String questionarionome = ResponderController.this.responderFRM.getQuestionariocb();

            int numeroqs = ResponderController.this.responderModel.verifica(questionarionome);
            DefaultTableModel dataModel=null;
            Session session = SessionFac.getSessionFactory().openSession();
            Transaction transaction = null;
            Vector<QuestaoTO> questaoTOVector = new Vector<>();



            try {
                List<QuestaoTO> deptoList = ResponderController.this.responderModel.questaoList(numeroqs);




                if(deptoList.get(ResponderController.this.responderFRM.getI()).getResp() == ResponderController.this.responderFRM.getRespostacorreta()){
                    candidatoTO.setAcertos(candidatoTO.getAcertos() + 1);



                }
                int numero = ResponderController.this.responderFRM.getI();


                if (numero+1 < deptoList.size()){
                    ResponderController.this.responderFRM.setI();

                    ResponderController.this.responderFRM.setAlb(deptoList.get(ResponderController.this.responderFRM.getI()).getAltA());
                    ResponderController.this.responderFRM.setBlb(deptoList.get(ResponderController.this.responderFRM.getI()).getAltB());
                    ResponderController.this.responderFRM.setPerguntalb(deptoList.get(ResponderController.this.responderFRM.getI()).getPergunta());
                    ResponderController.this.responderFRM.setClb(deptoList.get(ResponderController.this.responderFRM.getI()).getAltC());
                    ResponderController.this.responderFRM.setDlb(deptoList.get(ResponderController.this.responderFRM.getI()).getAltD());

                } else{
                    String nome = JOptionPane.showInputDialog("Qual Seu Nome??");

                    ResponderController.this.responderModel.cadastra(candidatoTO.getAcertos(), deptoList.size(), nome, numeroqs);

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


        }
    }

    class ResponderContinuarListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
             candidatoTO = new CandidatoTO();

           String questionarionome = ResponderController.this.responderFRM.getQuestionariocb();

           int numeroqs = ResponderController.this.responderModel.verifica(questionarionome);
            DefaultTableModel dataModel=null;

            Transaction transaction = null;
            Vector<QuestaoTO> questaoTOVector = new Vector<>();

            try {

                List<QuestaoTO> deptoList = ResponderController.this.responderModel.questaoList(numeroqs);
                for(QuestaoTO d : deptoList){
                    if(d.getQuestionario() == numeroqs){
                        questaoTOVector.add(d);


                    }

                }
                //Vector para os t�tulos das colunas

                //transaction.commit();
                
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

            ResponderController.this.responderFRM.setPerguntalb(questaoTOVector.get(ResponderController.this.responderFRM.getI()).getPergunta());

            ResponderController.this.responderFRM.setAlb(questaoTOVector.get(ResponderController.this.responderFRM.getI()).getAltA());
            ResponderController.this.responderFRM.setBlb(questaoTOVector.get(ResponderController.this.responderFRM.getI()).getAltB());
            ResponderController.this.responderFRM.setClb(questaoTOVector.get(ResponderController.this.responderFRM.getI()).getAltC());
            ResponderController.this.responderFRM.setDlb(questaoTOVector.get(ResponderController.this.responderFRM.getI()).getAltD());
ResponderController.this.responderFRM.mostrarTela(true);






        }
    }
}
