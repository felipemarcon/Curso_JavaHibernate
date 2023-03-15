package controller;

import dados.SessionFac;
import dao.QuestaoModel;
import dao.QuestionarioDAO;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import transporte.QuestaoTO;
import transporte.QuestionarioTO;
import view.QuestaoFRM;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class QuestaoController {
    private QuestaoFRM questaoFRM;
    private QuestaoTO questaoTO;
    private QuestaoModel questaoModel;

    public QuestaoController(QuestaoFRM questaoFRM, QuestaoModel questaoModel){
        this.questaoFRM = questaoFRM;
        this.questaoModel = questaoModel;
        this.questaoFRM.addGravarQsListener(new QuestaoController.QuestaoGravarListener());
        this.questaoFRM.addConsultarQsListener(new QuestaoController.QuestaoConsultarQsListener());
        this.questaoFRM.addExcluirQsListener(new QuestaoController.QuestaoExcluirQsListener());
    }
    public QuestaoController(){
        super();
    }

    public Vector<String> comboBoxConsulta(){
        Vector<String> eita = new Vector<String>();

        DefaultTableModel dataModel=null;

        Transaction transaction = null;

        try {

            Session session = SessionFac.getSessionFactory().openSession();
            transaction = (Transaction) session.beginTransaction();

            Query query = session.createQuery("from QuestionarioTO");
            List<QuestionarioTO> deptoList = ((org.hibernate.query.Query) query).list();
            for(QuestionarioTO d : deptoList){
                eita.add((String) ""+ d.getNome());

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
        return eita;
    }
    class QuestaoExcluirQsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int codquestao = 0;
            int numeropergunta = 0;
            String pergunta = "";
            String alt_a = "";
            String alt_b = "";
            String alt_c = "";
            String alt_d = "";
            int resp = 0;
            int questionario = 0;
            try {


                codquestao = QuestaoController.this.questaoFRM.getIdquestionario();
                String auxnmrpg = QuestaoController.this.questaoFRM.getNmrtf();
                numeropergunta = Integer.parseInt(auxnmrpg);
                pergunta = QuestaoController.this.questaoFRM.getQuestaotf();
                alt_a = QuestaoController.this.questaoFRM.getRespAtf();
                alt_b = QuestaoController.this.questaoFRM.getRespBtf();
                alt_c = QuestaoController.this.questaoFRM.getRespCtf();
                alt_d = QuestaoController.this.questaoFRM.getRespDtf();
                String auxquestao = QuestaoController.this.questaoFRM.getQuestionarioCB();
                questionario = QuestaoController.this.questaoModel.verifica(auxquestao);

                System.out.println(codquestao);
                resp = QuestaoController.this.questaoFRM.getRespostacorreta();

                QuestaoController.this.questaoTO = new QuestaoTO();
                QuestaoController.this.questaoTO.setCodquestao(codquestao);
                QuestaoController.this.questaoTO.setNmrpergunta(numeropergunta);
                QuestaoController.this.questaoTO.setPergunta(pergunta);
                QuestaoController.this.questaoTO.setAltA(alt_a);
                QuestaoController.this.questaoTO.setAltB(alt_b);
                QuestaoController.this.questaoTO.setAltC(alt_c);
                QuestaoController.this.questaoTO.setAltD(alt_d);
                QuestaoController.this.questaoTO.setQuestionario(questionario);
                QuestaoController.this.questaoTO.setResp(resp);
                Object[] options = {"SIM", "NAO"};
                int conf = 0;
                conf = JOptionPane.showOptionDialog(null,
                        "Confirma a Exclus�o?",
                        "Confirma��o",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(conf == 0){
                    QuestaoController.this.questaoModel.exclui(QuestaoController.this.questaoTO);

                    QuestaoController.this.questaoFRM.limpaTela();

                }

                QuestaoController.this.questaoFRM.limpaTela();


            } catch (Exception var8) {
                var8.printStackTrace();
            }

        }
    }



    class QuestaoGravarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int numeropergunta = 0;
            String pergunta = "";
            String alt_a = "";
            String alt_b = "";
            String alt_c = "";
            String alt_d = "";
            int resp = 0;
            int questionario = 0;


            try {

                String auxnmrpg = QuestaoController.this.questaoFRM.getNmrtf();
                numeropergunta = Integer.parseInt(auxnmrpg);
                pergunta = QuestaoController.this.questaoFRM.getQuestaotf();
                alt_a = QuestaoController.this.questaoFRM.getRespAtf();
                alt_b = QuestaoController.this.questaoFRM.getRespBtf();
                alt_c = QuestaoController.this.questaoFRM.getRespCtf();
                alt_d = QuestaoController.this.questaoFRM.getRespDtf();
                String auxquestao = QuestaoController.this.questaoFRM.getQuestionarioCB();
                questionario = QuestaoController.this.questaoModel.verifica(auxquestao);

                System.out.println(questionario);
                resp = QuestaoController.this.questaoFRM.getRespostacorreta();

                QuestaoController.this.questaoTO = new QuestaoTO();

                QuestaoController.this.questaoTO.setNmrpergunta(numeropergunta);
                QuestaoController.this.questaoTO.setPergunta(pergunta);
                QuestaoController.this.questaoTO.setAltA(alt_a);
                QuestaoController.this.questaoTO.setAltB(alt_b);
                QuestaoController.this.questaoTO.setAltC(alt_c);
                QuestaoController.this.questaoTO.setAltD(alt_d);
                QuestaoController.this.questaoTO.setQuestionario(questionario);
                QuestaoController.this.questaoTO.setResp(resp);
                char op = QuestaoController.this.questaoFRM.getOper();
                if (op == 'I') {
                    QuestaoController.this.questaoModel.insere(QuestaoController.this.questaoTO);
                } else {
                    //QuestionarioController.this.questionarioModel.atualiza(QuestionarioController.this.questionarioTO);
                }

                QuestaoController.this.questaoFRM.limpaTela();
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        }
    }
    class QuestaoConsultarQsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            questaoFRM.econderComponentes(false);



            DefaultTableModel dataModel=null;

            Transaction transaction = null;

            try {

                Session session = SessionFac.getSessionFactory().openSession();
                transaction = (Transaction) session.beginTransaction();

                Query query = session.createQuery("from QuestaoTO");
                List<QuestaoTO> deptoList = ((org.hibernate.query.Query) query).list();

                Vector dados = new Vector();
                for(QuestaoTO d : deptoList){
                    Vector<String> linha = new Vector<String>();
                    linha.add((String) ""+ d.getCodquestao());
                    linha.add((String) ""+ d.getNmrpergunta());
                    linha.add((String) ""+ d.getPergunta());
                    linha.add((String) ""+ d.getAltA());
                    linha.add((String) ""+ d.getAltB());
                    linha.add((String) ""+ d.getAltC());
                    linha.add((String) ""+ d.getAltD());
                    linha.add((String) ""+ d.getResp());


                    dados.add(linha);

                }
                //Vector para os t�tulos das colunas
                Vector<String> titulos = new Vector<String>();
                titulos.add("ID");
                titulos.add("Numero Pergunta");
                titulos.add("Pergunta");
                titulos.add("A");
                titulos.add("B");
                titulos.add("C");
                titulos.add("D");
                titulos.add("Resposta");

                dataModel = new DefaultTableModel(dados, titulos);


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

            questaoFRM.exibe_tabela(dataModel);
        }
    }
}
