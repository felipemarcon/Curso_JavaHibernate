package transporte;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "questionario"
)

public class QuestionarioTO {
    @Id
    @Column(
            name = "idquestionario"
    )
    private int idquestionario;

    @Id
    @Column(
            name = "nome"
    )
    private String nome;

    @Id
    @Column(
            name = "tema"
    )
    private String tema;

    public int getIdquestionario() {
        return idquestionario;
    }

    public void setIdquestionario(int idquestionario) {
        this.idquestionario = idquestionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public QuestionarioTO(int idquestionario, String nome, String tema) {
        super();
        this.idquestionario = idquestionario;
        this.nome = nome;
        this.tema = tema;
    }

    public QuestionarioTO(){
        super();
    }
}
