package br.gov.sp.fatec.projetointegrador.owner.model;

import br.gov.sp.fatec.projetointegrador.task.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Table(name="owner")
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer officeTime;

    @OneToMany(mappedBy = "owner")
    private List<Task> tasks;
}
