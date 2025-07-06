package AS.livro.autor.services;

import AS.livro.autor.dto.livros.request.LivroRequest;
import AS.livro.autor.dto.livros.response.LivroResponseDTO;
import AS.livro.autor.entities.Autor;
import AS.livro.autor.entities.Livro;
import AS.livro.autor.repositories.AutorRepository;
import AS.livro.autor.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public List<LivroResponseDTO> getLivros() {
        List<Livro> livros = livroRepository.findAll();

        return livros.stream().map(livro -> new LivroResponseDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getDescricao(),
                livro.getAutor().getNome(),
                livro.getAutor().getId()
        )).collect(Collectors.toList());
    }

    public LivroResponseDTO getLivro(Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow();

        return new LivroResponseDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getDescricao(),
                livro.getAutor().getNome(),
                livro.getAutor().getId()
        );
    }

    public LivroResponseDTO createLivro(LivroRequest livroRequest) {
        Autor autor = autorRepository.findById(livroRequest.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        Livro livro = new Livro();
        livro.setTitulo(livroRequest.getTitulo());
        livro.setDescricao(livroRequest.getDescricao());
        livro.setAutor(autor);

        Livro savedLivro = livroRepository.save(livro);

        return new LivroResponseDTO(
                savedLivro.getId(),
                savedLivro.getTitulo(),
                savedLivro.getDescricao(),
                savedLivro.getAutor().getNome(),
                savedLivro.getAutor().getId()
        );
    }

    public LivroResponseDTO updateLivro(Long id, LivroRequest livroRequest) {
        Livro livro = livroRepository.findById(id).orElseThrow();

        Autor autor = autorRepository.findById(livroRequest.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        livro.setTitulo(livroRequest.getTitulo());
        livro.setDescricao(livroRequest.getDescricao());
        livro.setAutor(autor);

        Livro updatedLivro = livroRepository.save(livro);

        return new LivroResponseDTO(
                updatedLivro.getId(),
                updatedLivro.getTitulo(),
                updatedLivro.getDescricao(),
                updatedLivro.getAutor().getNome(),
                updatedLivro.getAutor().getId()
        );
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
