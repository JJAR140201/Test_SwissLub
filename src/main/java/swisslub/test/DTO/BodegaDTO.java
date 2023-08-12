    package swisslub.test.DTO;

    import lombok.*;

    import javax.persistence.*;
    import java.util.List;

    @Entity
    @Table(name = "bodega")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class BodegaDTO {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String codigo;
        private String nombre;

        @OneToMany(mappedBy = "bodegaOrigen")
        private List<MovimientosDTO> movimientosOrigenList;

        @OneToMany(mappedBy = "bodegaDestino")
        private List<MovimientosDTO> movimientosDestinoList;
    }
