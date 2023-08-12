package swisslub.test.DTO;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovimientosDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String empresa;

    private String descripcion;

    private String fechaCreacion;

    private String fechaEntrega;

    private String estado;
}
