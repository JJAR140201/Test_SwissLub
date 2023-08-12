package swisslub.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swisslub.test.DTO.MovimientosDTO;

public interface MovimientoRopository extends JpaRepository<MovimientosDTO, Integer> {
}
