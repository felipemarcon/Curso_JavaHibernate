/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

package view;

import controller.QuestaoController;
import transporte.QuestionarioTO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 *
 * @author felip
 */
public class QuestaoFRM extends javax.swing.JFrame {

    /**
     * Creates new form NewJInternalFrame
     */

    private DefaultTableModel dataModel;
    private JTable tab;
    private JScrollPane sp;
    private int idquestao;
    private char oper = 'I';
    public QuestaoFRM() {
        initComponents();
        QuestaoController qs = new QuestaoController();
        questionarioCB.setModel(new javax.swing.DefaultComboBoxModel<>(qs.comboBoxConsulta()));



    }
    public char getOper() {
        return this.oper;
    }

    public void limpaTela(){
        nmrtf.setText("");
        questaotf.setText("");
        respAtf.setText("");
        respBtf.setText("");
        respCtf.setText("");
        respDtf.setText("");

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        respostacorreta = new javax.swing.ButtonGroup();
        tituloTxt = new javax.swing.JLabel();
        questionarioCB = new javax.swing.JComboBox<>();
        questionariolb = new javax.swing.JLabel();
        questaolb = new javax.swing.JLabel();
        questaotf = new javax.swing.JTextField();
        respAlb = new javax.swing.JLabel();
        respBlb = new javax.swing.JLabel();
        respClb = new javax.swing.JLabel();
        respDlb = new javax.swing.JLabel();
        respAtf = new javax.swing.JTextField();
        respBtf = new javax.swing.JTextField();
        respCtf = new javax.swing.JTextField();
        respDtf = new javax.swing.JTextField();
        respArbutton = new javax.swing.JRadioButton();
        respCrbutton = new javax.swing.JRadioButton();
        respBrbutton = new javax.swing.JRadioButton();
        respDrbutton = new javax.swing.JRadioButton();
        respcorrlb = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        nmrlb = new javax.swing.JLabel();
        nmrtf = new javax.swing.JTextField();

        tituloTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tituloTxt.setText("Cadastrar Questões");

        questionarioCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "eita" }));
        questionarioCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionarioCBActionPerformed(evt);
            }
        });

        questionariolb.setText("Questionario:");

        questaolb.setText("Questão:");

        respAlb.setText("Resposta A:");

        respBlb.setText("Resposta B:");

        respClb.setText("Resposta C:");

        respDlb.setText("Resposta D:");

        respostacorreta.add(respArbutton);
        respArbutton.setText("A");

        respostacorreta.add(respCrbutton);
        respCrbutton.setText("C");

        respostacorreta.add(respBrbutton);
        respBrbutton.setText("B");

        respostacorreta.add(respDrbutton);
        respDrbutton.setText("D");

        respcorrlb.setText("Resposta Correta:");

        btnCadastrar.setText("Cadastrar");

        btnConsultar.setText("Consultar");

        btnExcluir.setText("Excluir");

        nmrlb.setText("Nº :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(questionariolb)
                                                .addGap(18, 18, 18)
                                                .addComponent(questionarioCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(122, 122, 122)
                                                                .addComponent(btnConsultar)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(btnExcluir))
                                                        .addComponent(btnCadastrar)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(tituloTxt))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(respAlb)
                                                        .addComponent(respBlb)
                                                        .addComponent(respClb)
                                                        .addComponent(respDlb)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(nmrlb)
                                                                .addComponent(questaolb)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(questaotf)
                                                        .addComponent(respAtf)
                                                        .addComponent(respBtf)
                                                        .addComponent(respCtf)
                                                        .addComponent(respDtf, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nmrtf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(103, 103, 103)
                                                .addComponent(respArbutton)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(respcorrlb)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(respBrbutton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(respCrbutton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(respDrbutton)))))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tituloTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(questionarioCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(questionariolb))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nmrlb)
                                        .addComponent(nmrtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(questaolb)
                                        .addComponent(questaotf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(respAlb)
                                        .addComponent(respAtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(respBlb)
                                        .addComponent(respBtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(respClb)
                                        .addComponent(respCtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(respDlb)
                                        .addComponent(respDtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(respcorrlb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(respArbutton)
                                        .addComponent(respCrbutton)
                                        .addComponent(respBrbutton)
                                        .addComponent(respDrbutton))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCadastrar)
                                        .addComponent(btnConsultar)
                                        .addComponent(btnExcluir))
                                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>

    private void questionarioCBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public String getQuestaotf() {
        return questaotf.getText();
    }

    public String getQuestionarioCB() {
        return (String) "" + questionarioCB.getSelectedItem();
    }

    public String getRespAtf() {
        return respAtf.getText();
    }

    public String getRespBtf() {
        return respBtf.getText();
    }

    public String getRespCtf() {
        return respCtf.getText();
    }

    public String getRespDtf() {
        return respDtf.getText();
    }

    public int getRespostacorreta() {
        if (respArbutton.isSelected()){
            return 1;
        }
        if (respBrbutton.isSelected()){
            return 2;
        }
        if (respCrbutton.isSelected()){
            return 3;
        }
        if (respDrbutton.isSelected()){
            return 4;
        }
        return 0;
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
                        String numeropergunta = (String) tab.getValueAt(selectedRow,1);
                        String pergunta = (String) tab.getValueAt(selectedRow,2);
                        String ra = (String) tab.getValueAt(selectedRow,3);
                        String rb = (String) tab.getValueAt(selectedRow,4);
                        String rc = (String) tab.getValueAt(selectedRow,5);
                        String rd = (String) tab.getValueAt(selectedRow,6);
                        String resp = (String) tab.getValueAt(selectedRow,7);



                        nmrtf.setText(numeropergunta);
                        questaotf.setText(pergunta);
                        respAtf.setText(ra);
                        respBtf.setText(rb);
                        respCtf.setText(rc);
                        respDtf.setText(rd);
                        idquestao = aux_cod;
                        tab.clearSelection();
                        sp.setVisible(false);

                        oper = 'A';
                        econderComponentes(true);

                    }
                }
            });
        }
    }

    public void econderComponentes(boolean mostra){
tituloTxt.setVisible(mostra);
questaotf.setVisible(mostra);
questaolb.setVisible(mostra);
questionarioCB.setVisible(mostra);
questionariolb.setVisible(mostra);
nmrlb.setVisible(mostra);
nmrtf.setVisible(mostra);
respAtf.setVisible(mostra);
respArbutton.setVisible(mostra);
respAlb.setVisible(mostra);
        respBtf.setVisible(mostra);
        respBrbutton.setVisible(mostra);
        respBlb.setVisible(mostra);
        respCtf.setVisible(mostra);
        respCrbutton.setVisible(mostra);
        respClb.setVisible(mostra);
        respDtf.setVisible(mostra);
        respDrbutton.setVisible(mostra);
        respDlb.setVisible(mostra);
        respcorrlb.setVisible(mostra);
        btnConsultar.setVisible(mostra);
        btnCadastrar.setVisible(mostra);
        btnExcluir.setVisible(mostra);
    }

    public String getNmrtf() {
        return nmrtf.getText();
    }

    public void addGravarQsListener(ActionListener listenForGravarQsButton) {
        this.btnCadastrar.addActionListener(listenForGravarQsButton);
    }
    public void addConsultarQsListener(ActionListener listenForConsultarQsButton) {
        this.btnConsultar.addActionListener(listenForConsultarQsButton);
    }

    public void addExcluirQsListener(ActionListener listenForExcluirQsButton) {
        this.btnExcluir.addActionListener(listenForExcluirQsButton);
    }

    public int getIdquestionario(){
        return idquestao;
    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel questaolb;
    private javax.swing.JTextField questaotf;
    private javax.swing.JComboBox<String> questionarioCB;
    private javax.swing.JLabel questionariolb;
    private javax.swing.JLabel respAlb;
    private javax.swing.JRadioButton respArbutton;
    private javax.swing.JTextField respAtf;
    private javax.swing.JLabel respBlb;
    private javax.swing.JRadioButton respBrbutton;
    private javax.swing.JTextField respBtf;
    private javax.swing.JLabel respClb;
    private javax.swing.JRadioButton respCrbutton;
    private javax.swing.JTextField respCtf;
    private javax.swing.JLabel respDlb;
    private javax.swing.JRadioButton respDrbutton;
    private javax.swing.JTextField respDtf;
    private javax.swing.JLabel respcorrlb;
    private javax.swing.ButtonGroup respostacorreta;
    private javax.swing.JLabel tituloTxt;
    private javax.swing.JLabel nmrlb;
    private javax.swing.JTextField nmrtf;
    // End of variables declaration
}
