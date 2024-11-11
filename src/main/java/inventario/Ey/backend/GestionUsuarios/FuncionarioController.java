package inventario.Ey.backend.GestionUsuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "http://localhost:4200")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioDTO> createFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO createdFuncionario = funcionarioService.createFuncionario(funcionarioDTO);
        return new ResponseEntity<>(createdFuncionario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO updatedFuncionario = funcionarioService.updateFuncionario(id, funcionarioDTO);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> getFuncionarioById(@PathVariable Long id) {
        FuncionarioDTO funcionario = funcionarioService.getFuncionarioById(id);
        return ResponseEntity.ok(funcionario);
    }

    // Método para obtener todos los funcionarios con paginación
    @GetMapping
    public ResponseEntity<Page<FuncionarioDTO>> getAllFuncionarios(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<FuncionarioDTO> funcionariosPage = funcionarioService.getFuncionariosPaginated(pageable);
        return ResponseEntity.ok(funcionariosPage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/identificacion/{identificacion}")
    public ResponseEntity<FuncionarioDTO> getFuncionarioByIdentificacion(@PathVariable String identificacion) {
        Optional<FuncionarioDTO> funcionario = funcionarioService.getByIdentificacion(identificacion);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
