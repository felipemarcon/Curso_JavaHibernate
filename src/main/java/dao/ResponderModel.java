package dao;

import transporte.QuestaoTO;

import java.util.List;
import java.util.Vector;

public class ResponderModel {
    ResponderDAO responderDAO = new ResponderDAO();

    public int verifica(String nome) {
        return this.responderDAO.VerificaQuestionario(nome);
    }

    public List<QuestaoTO> questaoList(int numeroqs){
        return this.responderDAO.QuestaoList(numeroqs);
    }

    public void cadastra(int acertos, int perguntas, String nome, int numeroqs){
        this.responderDAO.cadastra(acertos, perguntas, nome, numeroqs);
    }





}
