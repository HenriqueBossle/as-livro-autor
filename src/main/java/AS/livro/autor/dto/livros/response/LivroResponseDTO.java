package AS.livro.autor.dto.livros.response;

public class LivroResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String autorNome;
    private Long autorId;

    public LivroResponseDTO() {}

    public LivroResponseDTO(Long id, String titulo, String descricao, String autorNome, Long autorId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autorNome = autorNome;
        this.autorId = autorId;
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

    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}
