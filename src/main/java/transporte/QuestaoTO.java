package transporte;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "questao"
)
public class QuestaoTO {

    @Id
    @Column(
            name = "codquestao"
    )
    private int codquestao;

    @Column(
            name = "numeropergunta"
    )
    private int nmrpergunta;

    @Column(
            name = "pergunta"
    )
    private String pergunta;

    @Column(
            name = "alt_a"
    )
    private String altA;

    @Column(
            name = "alt_b"
    )
    private String altB;

    @Column(
            name = "alt_c"
    )
    private String altC;

    @Column(
            name = "alt_d"
    )
    private String altD;

    @Column(
            name = "resp"
    )
    private int resp;

    @Column(
            name = "questionario"
    )
    private int questionario;

    public QuestaoTO() {
        super();
    }

    public int getCodquestao() {
        return codquestao;
    }

    public void setCodquestao(int codquestao) {
        this.codquestao = codquestao;
    }

    public int getNmrpergunta() {
        return nmrpergunta;
    }

    public void setNmrpergunta(int nmrpergunta) {
        this.nmrpergunta = nmrpergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getAltA() {
        return altA;
    }

    public void setAltA(String altA) {
        this.altA = altA;
    }

    public String getAltB() {
        return altB;
    }

    public void setAltB(String altB) {
        this.altB = altB;
    }

    public String getAltC() {
        return altC;
    }

    public void setAltC(String altC) {
        this.altC = altC;
    }

    public String getAltD() {
        return altD;
    }

    public void setAltD(String altD) {
        this.altD = altD;
    }

    public int getResp() {
        return resp;
    }

    public void setResp(int resp) {
        this.resp = resp;
    }

    public int getQuestionario() {
        return questionario;
    }

    public void setQuestionario(int questionario) {
        this.questionario = questionario;
    }

    public QuestaoTO(int codquestao, int nmrpergunta, String pergunta, String altA, String altB, String altC, String altD, int resp, int questionario) {
        super();
        this.codquestao = codquestao;
        this.nmrpergunta = nmrpergunta;
        this.pergunta = pergunta;
        this.altA = altA;
        this.altB = altB;
        this.altC = altC;
        this.altD = altD;
        this.resp = resp;
        this.questionario = questionario;
    }
}
