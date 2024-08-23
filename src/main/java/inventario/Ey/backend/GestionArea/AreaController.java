package inventario.Ey.backend.GestionArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
@CrossOrigin(origins = "http://localhost:4200")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @PostMapping
    public ResponseEntity<Area> createArea(@RequestBody AreaDTO areaDTO) {
        try {
            Area area = areaService.createArea(areaDTO);
            return new ResponseEntity<>(area, HttpStatus.CREATED);
        } catch (AreaAlreadyExistsException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> updateArea(@PathVariable Long id, @RequestBody AreaDTO areaDTO) {
        try {
            Area updatedArea = areaService.updateArea(id, areaDTO);
            return new ResponseEntity<>(updatedArea, HttpStatus.OK);
        } catch (AreaAlreadyExistsException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        } catch (AreaNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable Long id) {
        try {
            areaService.deleteArea(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AreaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable Long id) {
        try {
            Area area = areaService.getAreaById(id);
            return new ResponseEntity<>(area, HttpStatus.OK);
        } catch (AreaNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Area>> getAllAreas() {
        return new ResponseEntity<>(areaService.getAllAreas(), HttpStatus.OK);
    }
}
