package swisslub.test.DTO;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "empresas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpresaDTO {
    @Id
    private int id;
    private String nombre;
}