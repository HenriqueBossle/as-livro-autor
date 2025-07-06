package AS.livro.autor.controllers;

import AS.livro.autor.dto.livros.request.LivroRequest;
import AS.livro.autor.dto.livros.response.LivroResponseDTO;
import AS.livro.autor.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> getLivros() {
        List<LivroResponseDTO> livros = livroService.getLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> getLivro(@PathVariable Long id) {
        LivroResponseDTO livro = livroService.getLivro(id);
        return ResponseEntity.ok(livro);
    }

    @PostMapping
    public ResponseEntity<LivroResponseDTO> createLivro(@RequestBody LivroRequest livroRequest) {
        LivroResponseDTO createdLivro = livroService.createLivro(livroRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdLivro.getId())
                .toUri();

        return ResponseEntity.created(uri).body(createdLivro);
    }


    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> updateLivro(@PathVariable Long id, @RequestBody LivroRequest livroRequest) {
        LivroResponseDTO updatedLivro = livroService.updateLivro(id, livroRequest);
        return ResponseEntity.ok(updatedLivro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.deleteLivro(id);
        return ResponseEntity.noContent().build();
    }
}
