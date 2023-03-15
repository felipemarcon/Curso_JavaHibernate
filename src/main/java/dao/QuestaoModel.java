package dao;

import transporte.QuestaoTO;

public class QuestaoModel {

    QuestaoDAO questaoDAO = new QuestaoDAO();

    public void insere(QuestaoTO aluno) {
        this.questaoDAO.insere(aluno);
    }
    public void exclui(QuestaoTO aluno) {
        this.questaoDAO.exclui(aluno);
    }

    public int verifica(String nome) {
        return this.questaoDAO.VerificaQuestionario(nome);
    }
}
