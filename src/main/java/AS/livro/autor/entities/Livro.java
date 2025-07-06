package AS.livro.autor.entities;

import jakarta.persistence.*;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro() {}

    public Livro(Long id, String titulo, String descricao, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
