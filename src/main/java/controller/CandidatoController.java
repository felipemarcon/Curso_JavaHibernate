package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dados.SessionFac;
import dao.CandidatoModel;
import dao.QuestaoModel;
import jakarta.persistence.Query;
import transporte.CandidatoTO;
import transporte.QuestaoTO;
import transporte.QuestionarioTO;
import view.CandidatoFRM;
import view.QuestaoFRM;

public class CandidatoController {
	private CandidatoFRM candidatoFRM;
	private CandidatoModel candidatoModel;
	private CandidatoTO candidatoTO;

	    public CandidatoController(CandidatoFRM candidatoFRM, CandidatoModel candidatoModel){
	    	candidatoTO =new CandidatoTO();
	    	
	        this.candidatoFRM = candidatoFRM;
	        this.candidatoModel = candidatoModel;
	        this.candidatoFRM.addConsultarCandListener(new CandidatoController.QuestaoConsultarCandListener());
	        this.candidatoFRM.addExcluirCandListener(new CandidatoController.QuestaoExcluirCandListener());
	    }
	    
	    class QuestaoConsultarCandListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				 candidatoFRM.econderComponentes(false);



		            DefaultTableModel dataModel=null;

		            Transaction transaction = null;

		            try {

		                Session session = SessionFac.getSessionFactory().openSession();
		                transaction = (Transaction) session.beginTransaction();

		                Query query = session.createQuery("from CandidatoTO");
		                List<CandidatoTO> deptoList = ((org.hibernate.query.Query) query).list();

		                Vector dados = new Vector();
		                for(CandidatoTO d : deptoList){
		                    Vector<String> linha = new Vector<String>();
		                    linha.add((String) "" + d.getCodcandi());
		                    linha.add((String) "" + d.getNomecandi());
		                    linha.add((String) "" + d.getAcertos());
		                    linha.add((String) "" + d.getNota());
		                    linha.add((String) "" + d.getQuestionario());
		                  

		                    dados.add(linha);

		                }
		                //Vector para os t�tulos das colunas
		                Vector<String> titulos = new Vector<String>();
		                titulos.add("ID");
		                titulos.add("Nome");
		                titulos.add("Acertos");
		                titulos.add("Nota");
		                titulos.add("Questionario");


		                dataModel = new DefaultTableModel(dados, titulos);


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

		            candidatoFRM.exibe_tabela(dataModel);
		        }
				
			}
	    
	    class QuestaoExcluirCandListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 int id;
				 String nome;
				 int acertos;
				 Double nota;
				 int questionario;

		            try {

		            	id = candidatoFRM.getCodCandi();
		               System.out.println("ID: "+id);
		            	
		            	candidatoTO.setCodcandi(id);
		                
		                
		                int conf = 0;
		                Object[] options = {"SIM", "NAO"};
		                conf = JOptionPane.showOptionDialog(null,
		                        "Confirma a Exclus�o?",
		                        "Confirma��o",
		                        JOptionPane.YES_NO_OPTION,
		                        JOptionPane.QUESTION_MESSAGE,
		                        null,
		                        options,
		                        options[0]);
		                if(conf == 0){
		                	CandidatoController.this.candidatoModel.exclui(candidatoTO);
		                	
		                    
		                    CandidatoController.this.candidatoFRM.limpatela();

		                }


		            } catch (Exception var8) {
		                var8.printStackTrace();
		            }

			}
	    	
	    }

	    	
	    
	    
}
