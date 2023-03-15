package controller;

import dados.SessionFac;
import dao.QuestionarioModel;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import transporte.QuestionarioTO;
import view.QuestionarioFRM;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class QuestionarioController {
private QuestionarioTO questionarioTO;
private QuestionarioFRM questionarioFRM;
private QuestionarioModel questionarioModel;

public QuestionarioController(QuestionarioFRM questionarioFRM, QuestionarioModel questionarioModel){
this.questionarioFRM =  questionarioFRM;
this.questionarioModel = questionarioModel;
this.questionarioFRM.addSalvarListener(new QuestionarioController.QuestionarioSalvarListener());
    this.questionarioFRM.addExcluirListener(new QuestionarioController.QuestionarioExcluirListener());
    this.questionarioFRM.addConsultarListener(new QuestionarioController.QuestionarioConsultarListener());
}

class QuestionarioSalvarListener implements ActionListener{
QuestionarioSalvarListener(){
}

    public void actionPerformed(ActionEvent e) {

        String nome = "";
        String tema = "";

        try {

            nome = QuestionarioController.this.questionarioFRM.getNometf();
            tema = QuestionarioController.this.questionarioFRM.getTematf();
            QuestionarioController.this.questionarioTO = new QuestionarioTO();

            QuestionarioController.this.questionarioTO.setNome(nome);
            QuestionarioController.this.questionarioTO.setTema(tema);
            char op = QuestionarioController.this.questionarioFRM.getOper();
            if (op == 'I') {
                QuestionarioController.this.questionarioModel.insere(QuestionarioController.this.questionarioTO);
            } else {
                //QuestionarioController.this.questionarioModel.atualiza(QuestionarioController.this.questionarioTO);
            }

            QuestionarioController.this.questionarioFRM.limpaTela();
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }
}

    class QuestionarioExcluirListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String nome = "";
            String tema = "";
            int id = 0;

            try {

                id = QuestionarioController.this.questionarioFRM.getIdquestionario();
                nome = QuestionarioController.this.questionarioFRM.getNometf();
                tema = QuestionarioController.this.questionarioFRM.getTematf();
                QuestionarioController.this.questionarioTO = new QuestionarioTO();


                QuestionarioController.this.questionarioTO.setIdquestionario(id);
                QuestionarioController.this.questionarioTO.setNome(nome);
                QuestionarioController.this.questionarioTO.setTema(tema);
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
                    QuestionarioController.this.questionarioModel.exclui(questionarioTO);

                    QuestionarioController.this.questionarioFRM.limpaTela();

                }


            } catch (Exception var8) {
                var8.printStackTrace();
            }

        }
    }

    class QuestionarioConsultarListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            questionarioFRM.econderComponentes(false);



            DefaultTableModel dataModel=null;

            Transaction transaction = null;

            try {

                Session session = SessionFac.getSessionFactory().openSession();
                transaction = (Transaction) session.beginTransaction();

                Query query = session.createQuery("from QuestionarioTO");
                List<QuestionarioTO> deptoList = ((org.hibernate.query.Query) query).list();

                Vector dados = new Vector();
                for(QuestionarioTO d : deptoList){
                    Vector<String> linha = new Vector<String>();
                    linha.add((String) ""+ d.getIdquestionario());
                    linha.add((String) "" + d.getNome());
                    linha.add((String) "" + d.getTema());

                    dados.add(linha);

                }
                //Vector para os t�tulos das colunas
                Vector<String> titulos = new Vector<String>();
                titulos.add("ID");
                titulos.add("Nome");
                titulos.add("Tema");


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

            questionarioFRM.exibe_tabela(dataModel);
        }
    }
}
