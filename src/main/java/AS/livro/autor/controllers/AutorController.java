package AS.livro.autor.controllers;

import AS.livro.autor.dto.autores.AutorResponseDTO;
import AS.livro.autor.entities.Autor;
import AS.livro.autor.services.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> getAutores() {
        List<AutorResponseDTO> autores = autorService.getAutores();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> getAutor(@PathVariable Long id) {
        AutorResponseDTO autorDTO = autorService.getAutorDTO(id);
        return ResponseEntity.ok(autorDTO);
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> createAutor(@RequestBody Autor autor) {
        AutorResponseDTO savedAutor = autorService.createAutor(autor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedAutor.getId()).toUri();

        return ResponseEntity.created(uri).body(savedAutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> updateAutor(@PathVariable Long id, @RequestBody Autor autorAtualizado) {
        AutorResponseDTO autorDTO = autorService.updateAutor(id, autorAtualizado);
        return ResponseEntity.ok(autorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}
