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

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaDTO empresa;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "bodega_origen_codigo")
    private BodegaDTO bodegaOrigen;

    @ManyToOne
    @JoinColumn(name = "bodega_destino_codigo")
    private BodegaDTO bodegaDestino;

    @Column(name = "fecha_creacion", length = 10)
    private char fechaCreacion;

    @Column(name = "fecha_entrega", length = 10)
    private char fechaEntrega;

    private char estado;
}
