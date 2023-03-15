package dao;

import transporte.QuestionarioTO;

public class QuestionarioModel {

    QuestionarioDAO atletaDAO = new QuestionarioDAO();

    public void insere(QuestionarioTO aluno) {
        this.atletaDAO.insere(aluno);
    }
    public void exclui(QuestionarioTO aluno) {
        this.atletaDAO.exclui(aluno);
    }
}

