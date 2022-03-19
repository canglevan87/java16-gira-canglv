package cybersoft.javabackend.java16giracanglv.role.model;

import cybersoft.javabackend.java16giracanglv.common.BaseEntity;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "GIRA_GROUP")
@Data
@SuperBuilder
public class GiraGroup extends BaseEntity {

    @Size(min = 5, max = 10)
    private String code;
    @NotBlank
    private String description;

    @ManyToMany(cascade ={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "GIRA_GROUP_ROLE",
            joinColumns = @JoinColumn(name = "GROUP_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
     private  Set<GiraRole> roles = new LinkedHashSet<>();


}
