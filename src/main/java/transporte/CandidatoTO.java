package transporte;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "candidato"
)

public class CandidatoTO {
    @Id
    @Column(
            name = "idcandidato"
    )
    private int codcandi;

    @Column(
            name = "nome"
    )
    private String nomecandi;

    @Column(
            name = "acertos"
    )
    private int acertos;

    @Column(
            name = "nota"
    )
    private Double nota;


    @Column(
            name = "questionario"
    )
    private int questionario;

    public CandidatoTO() {
        super();
    }

    public CandidatoTO(int codcandi, String nomecandi, int acertos, Double nota, int questionario) {
        this.codcandi = codcandi;
        this.nomecandi = nomecandi;
        this.acertos = acertos;
        this.nota = nota;
        this.questionario = questionario;
    }

    public int getCodcandi() {
        return codcandi;
    }

    public void setCodcandi(int codcandi) {
        this.codcandi = codcandi;
    }

    public String getNomecandi() {
        return nomecandi;
    }

    public void setNomecandi(String nomecandi) {
        this.nomecandi = nomecandi;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getQuestionario() {
        return questionario;
    }

    public void setQuestionario(int questionario) {
        this.questionario = questionario;
    }
}
