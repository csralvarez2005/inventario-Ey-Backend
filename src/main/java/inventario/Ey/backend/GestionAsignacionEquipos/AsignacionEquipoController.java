package inventario.Ey.backend.GestionAsignacionEquipos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class AsignacionEquipoController {

    @Autowired
    private AsignacionEquipoService asignacionEquipoService;

    @GetMapping
    public ResponseEntity<List<AsignacionEquipoDTO>> obtenerTodasLasAsignaciones() {
        return ResponseEntity.ok(asignacionEquipoService.obtenerTodasLasAsignaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionEquipoDTO> obtenerAsignacionPorId(@PathVariable Long id) {
        return ResponseEntity.ok(asignacionEquipoService.obtenerAsignacionPorId(id));
    }

    @PostMapping
    public ResponseEntity<AsignacionEquipoDTO> crearAsignacion(@RequestBody AsignacionEquipoDTO asignacionDTO) {
        return ResponseEntity.ok(asignacionEquipoService.crearAsignacion(asignacionDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionEquipoDTO> actualizarAsignacion(@PathVariable Long id, @RequestBody AsignacionEquipoDTO asignacionDTO) {
        return ResponseEntity.ok(asignacionEquipoService.actualizarAsignacion(id, asignacionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignacion(@PathVariable Long id) {
        asignacionEquipoService.eliminarAsignacion(id);
        return ResponseEntity.noContent().build();
    }
}
