package swisslub.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swisslub.test.DTO.MovimientoDetalle;

public interface MovimientosDetallesReposiroty extends JpaRepository<MovimientoDetalle, Integer> {
}
