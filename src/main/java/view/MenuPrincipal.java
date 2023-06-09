/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CandidatoController;
import controller.QuestaoController;
import controller.QuestionarioController;
import controller.ResponderController;
import dao.CandidatoModel;
import dao.QuestaoModel;
import dao.QuestionarioModel;
import dao.ResponderModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
/**
 *
 * @author Aluno
 */
public class MenuPrincipal extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        setVisible(true);
        this.menuQuestionario.addActionListener(this);
        this.menuQuestoes.addActionListener(this);
        this.menuResponder.addActionListener(this);
        this.menuCandidatos.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        topMenuCadastrar = new javax.swing.JMenu();
        menuQuestionario = new javax.swing.JMenuItem();
        menuQuestoes = new javax.swing.JMenuItem();
        topMenuQuestionarios = new javax.swing.JMenu();
        menuResponder = new javax.swing.JMenuItem();
        topMenuConsultar = new javax.swing.JMenu();
        menuCandidatos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        topMenuCadastrar.setText("Cadastrar");

        menuQuestionario.setText("Questionario");
        menuQuestionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuestionarioActionPerformed(evt);
            }
        });
        topMenuCadastrar.add(menuQuestionario);

        menuQuestoes.setText("Questoes");
        topMenuCadastrar.add(menuQuestoes);

        jMenuBar1.add(topMenuCadastrar);

        topMenuQuestionarios.setText("Questionarios");

        menuResponder.setText("Responder");
        menuResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuResponderActionPerformed(evt);
            }
        });
        topMenuQuestionarios.add(menuResponder);

        jMenuBar1.add(topMenuQuestionarios);

        topMenuConsultar.setText("Consultar");

        menuCandidatos.setText("Candidatos");
        topMenuConsultar.add(menuCandidatos);

        jMenuBar1.add(topMenuConsultar);

        setJMenuBar(jMenuBar1);

        menuQuestoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuestoesActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void menuQuestionarioActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }

    private void menuQuestoesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void menuResponderActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }

    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();
        if (src == this.menuQuestionario) {
            this.createFrame(1);
            System.out.println("eita");
        }
        if (src == this.menuQuestoes) {
            this.createFrame(2);
            System.out.println("eita");
        }

        if (src == this.menuResponder) {
            this.createFrame(3);
            System.out.println("eita");
        }
        
        if (src == this.menuCandidatos) {
            this.createFrame(4);
            System.out.println("eita");
        }

    }

    protected void createFrame(int opcao) {
        Dimension desktopSize;
        Dimension jInternalFrameSize;
        switch (opcao) {
            case 1:
                QuestionarioFRM alunoFrm = new QuestionarioFRM();
                QuestionarioModel alunoModel = new QuestionarioModel();
                new QuestionarioController(alunoFrm, alunoModel);

                alunoFrm.setVisible(true);

                desktopSize = this.getSize();
                jInternalFrameSize = alunoFrm.getSize();
                alunoFrm.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2 - 200);
break;
            case 2:
                QuestaoFRM alunoFrm2 = new QuestaoFRM();
                QuestaoModel alunoModel2 = new QuestaoModel();
                new QuestaoController(alunoFrm2, alunoModel2);
                alunoFrm2.setVisible(true);

                Dimension desktopSize2 = this.getSize();
                Dimension jInternalFrameSize2 = alunoFrm2.getSize();
                alunoFrm2.setLocation((desktopSize2.width - jInternalFrameSize2.width) / 2, (desktopSize2.height - jInternalFrameSize2.height) / 2 - 100);



                break;

            case 3:

                ResponderFRM responderFRM = new ResponderFRM();
                ResponderModel responderModel = new ResponderModel();
                new ResponderController(responderFRM, responderModel);
                responderFRM.setVisible(true);

                break;
                
            case 4:

                CandidatoFRM candidatoFRM = new CandidatoFRM();
                CandidatoModel candidatoModel = new CandidatoModel();
                
                new CandidatoController(candidatoFRM, candidatoModel);
                
                candidatoFRM.setVisible(true);

                break;

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuCandidatos;
    private javax.swing.JMenuItem menuQuestionario;
    private javax.swing.JMenuItem menuQuestoes;
    private javax.swing.JMenuItem menuResponder;
    private javax.swing.JMenu topMenuCadastrar;
    private javax.swing.JMenu topMenuConsultar;
    private javax.swing.JMenu topMenuQuestionarios;
    // End of variables declaration                   
}
