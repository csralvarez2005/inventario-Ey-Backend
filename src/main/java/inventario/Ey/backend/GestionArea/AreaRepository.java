package inventario.Ey.backend.GestionArea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {
    Optional<Area> findByNombre(String nombre);

    @Query("SELECT a FROM Area a ORDER BY a.nombre DESC")
    List<Area> findAllOrderedByNombreDesc();
}
