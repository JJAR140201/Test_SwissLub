package swisslub.test.DTO;
import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "movimiento_detalle")
public class MovimientoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    @JoinColumn(name = "movimiento_id")
    private MovimientosDTO movimiento;
    @Column(name = "producto")
    private String producto;
    @Column(name = "cantidad_enviada")
    private int cantidadEnviada;
}
