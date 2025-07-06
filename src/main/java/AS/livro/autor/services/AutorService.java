package AS.livro.autor.services;

import AS.livro.autor.dto.autores.AutorLivroDTO;
import AS.livro.autor.dto.autores.AutorResponseDTO;
import AS.livro.autor.entities.Autor;
import AS.livro.autor.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorResponseDTO> getAutores() {
        List<Autor> autores = autorRepository.findAll();

        return autores.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AutorResponseDTO getAutorDTO(Long id) {
        Autor autor = autorRepository.findById(id).orElseThrow();
        return mapToDTO(autor);
    }

    public AutorResponseDTO createAutor(Autor autor) {
        Autor saved = autorRepository.save(autor);
        return mapToDTO(saved);
    }

    public AutorResponseDTO updateAutor(Long id, Autor autorAtualizado) {
        Autor autor = autorRepository.findById(id).orElseThrow();

        autor.setNome(autorAtualizado.getNome());
        autor.setEmail(autorAtualizado.getEmail());
        autor.setBiografia(autorAtualizado.getBiografia());

        Autor updated = autorRepository.save(autor);
        return mapToDTO(updated);
    }

    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }

    // Método auxiliar para converter Autor para AutorResponseDTO
    private AutorResponseDTO mapToDTO(Autor autor) {
        return new AutorResponseDTO(
                autor.getId(),
                autor.getNome(),
                autor.getEmail(),
                autor.getBiografia(),
                autor.getLivros().stream()
                        .map(livro -> new AutorLivroDTO(
                                livro.getId(),
                                livro.getTitulo(),
                                livro.getDescricao()
                        ))
                        .collect(Collectors.toList())
        );
    }
}
