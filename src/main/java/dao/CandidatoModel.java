package dao;

import transporte.CandidatoTO;
import transporte.QuestaoTO;

public class CandidatoModel {
	CandidatoDAO candidatoDAO = new CandidatoDAO();
	

	
	public void exclui(CandidatoTO candidatoTO) {
        this.candidatoDAO.exclui(candidatoTO);
    }
}
