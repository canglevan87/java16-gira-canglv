package cybersoft.javabackend.java16giracanglv.role.model;

import cybersoft.javabackend.java16giracanglv.common.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name="GIRA_ROLE")
@Getter
@Setter
@Data
@SuperBuilder
public class GiraRole extends BaseEntity {

    @Size(min=5,max=5)
    private String code;
    @NotBlank
    private String description;
    @ManyToMany(mappedBy = "roles")
    private Set<GiraGroup> groups = new LinkedHashSet();
}
