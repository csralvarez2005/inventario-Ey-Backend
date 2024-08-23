package inventario.Ey.backend.GestionEquipos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "http://localhost:4200")

public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<EquipoDTO> getAllEquipos() {
        return equipoService.findAll();
    }

    @GetMapping("/{id}")
    public EquipoDTO getEquipoById(@PathVariable Long id) {
        return equipoService.findById(id);
    }

    @PostMapping
    public EquipoDTO createEquipo(@RequestBody EquipoDTO equipoDTO) {
        return equipoService.create(equipoDTO);
    }

    @PutMapping("/{id}")
    public EquipoDTO updateEquipo(@PathVariable Long id, @RequestBody EquipoDTO equipoDTO) {
        return equipoService.update(id, equipoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        equipoService.delete(id);
    }
}
