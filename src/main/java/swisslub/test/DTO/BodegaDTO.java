package swisslub.test.DTO;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bodega")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BodegaDTO {
    @Id
    private String codigo;
    private String nombre;
}
