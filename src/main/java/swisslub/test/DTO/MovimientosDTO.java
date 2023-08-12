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

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private String fechaCreacion;

    @Column(name = "fecha_entrega")
    private String fechaEntrega;

    @Column(name = "estado")
    private String estado;
}
