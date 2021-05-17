package exercicioJDBC;

public class Curso {

    private int id;
    private String nome;
    private int duracaoHoras;

    public Curso() { }

    public Curso(String nome, int duracaoHoras) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(int id, String nome, int duracaoHoras) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curso{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", duracaoHoras=").append(duracaoHoras);
        sb.append('}');
        return sb.toString();
    }


}
