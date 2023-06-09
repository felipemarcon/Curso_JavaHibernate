package view;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */


import transporte.QuestionarioTO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author felip
 */
public class QuestionarioFRM extends javax.swing.JFrame {

    /**
     * Creates new form QuestionarioFRM
     */
    private DefaultTableModel dataModel;
    private JTable tab;
    private JScrollPane sp;
    private QuestionarioTO questionario;
    private int idquestionario;
    private char oper = 'I';
    public QuestionarioFRM() {
        initComponents();
        setVisible(true);
    }
    public char getOper() {
        return this.oper;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        btnCadastrar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        nomelb = new javax.swing.JLabel();
        temalb = new javax.swing.JLabel();
        nometf = new javax.swing.JTextField();
        tematf = new javax.swing.JTextField();
        btnconsultar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        btnCadastrar.setText("Cadastrar");


        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Cadastrar Questionarios");

        nomelb.setText("Nome:");

        temalb.setText("Tema:");

        btnconsultar.setText("Consultar");

        btnExcluir.setText("Excluir");



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nomelb)
                                        .addComponent(temalb))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tematf, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nometf, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(121, 121, 121))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(btnCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(btnconsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir)
                                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nomelb)
                                        .addComponent(nometf, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(temalb)
                                        .addComponent(tematf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCadastrar)
                                        .addComponent(btnconsultar)
                                        .addComponent(btnExcluir))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();

    }// </editor-fold>

public void econderComponentes(boolean mostrar){
        jLabel1.setVisible(mostrar);
        nomelb.setVisible(mostrar);
        nometf.setVisible(mostrar);
        tematf.setVisible(mostrar);
        temalb.setVisible(mostrar);
        btnCadastrar.setVisible(mostrar);
        btnExcluir.setVisible(mostrar);
        btnconsultar.setVisible(mostrar);


    }

    public void exibe_tabela(DefaultTableModel dados){
        dataModel = dados;

        if(dataModel != null){
            tab = new JTable(dataModel);
            tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            sp = new JScrollPane( tab );
            this.getContentPane().add(sp);
            sp.setBounds(0,0,500,200);

            tab.addKeyListener(new KeyAdapter(){//Tabela "Escuta" o ESC e � ocultada
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()==27){ //tecla 27 � o ESC
                        sp.setVisible(false);
                        econderComponentes(true);
                    }
                }
            });

            ListSelectionModel cel = tab.getSelectionModel();

            cel.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                    if (!lsm.isSelectionEmpty()) {
                        int selectedRow = tab.getSelectedRow();
                        int selectedCol = tab.getSelectedColumn();

                        String cod = (String) ""+tab.getValueAt(selectedRow,0);
                        int aux_cod = Integer.parseInt(cod);
                        String nomeQuestionario = (String) tab.getValueAt(selectedRow,1);
                        String temaQuestionario = (String) tab.getValueAt(selectedRow,2);



                        questionario = new QuestionarioTO(aux_cod ,nomeQuestionario, temaQuestionario);
                        nometf.setText(nomeQuestionario);
                        tematf.setText(temaQuestionario);
                        idquestionario = aux_cod;
                        tab.clearSelection();
                        sp.setVisible(false);

                        oper = 'A';
                        econderComponentes(true);

                    }
                }
            });
        }
    }

    public void addSalvarListener(ActionListener listenForSalvarButton) {
        this.btnCadastrar.addActionListener(listenForSalvarButton);
    }

    public void addConsultarListener(ActionListener listenForConsultarButton) {
        this.btnconsultar.addActionListener(listenForConsultarButton);
    }

    public void addExcluirListener(ActionListener listenForExcluirButton) {
        this.btnExcluir.addActionListener(listenForExcluirButton);
    }

    public String getNome() {
        return this.nometf.getText();
    }



    // Variables declaration - do not modify
    private javax.swing.JToggleButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nomelb;
    private javax.swing.JTextField nometf;
    private javax.swing.JLabel temalb;
    private javax.swing.JTextField tematf;

    public void setSelected(boolean b) {
    }
    // End of variables declaration
public void limpaTela(){
        nometf.setText("");
        tematf.setText("");
}

    public String getNometf() {
        return nometf.getText();
    }

    public void setNometf(String aee) {
        this.nometf.setText(aee);
    }

    public String getTematf() {
        return tematf.getText();
    }

    public void setTematf(String aee) {
        this.tematf.setText(aee);
    }

    public int getIdquestionario(){
        return idquestionario;
    }
}
