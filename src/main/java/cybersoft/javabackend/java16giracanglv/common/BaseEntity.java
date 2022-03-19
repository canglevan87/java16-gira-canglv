package cybersoft.javabackend.java16giracanglv.common;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.asm.Advice;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
@MappedSuperclass
@Data
@SuperBuilder
public abstract class BaseEntity implements Serializable {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    protected UUID id;

    @Version
    protected Long version;
    @CreatedDate
    protected LocalDateTime createdDate;
    @CreatedBy
    protected String createdBy;
    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;
    @LastModifiedBy
    protected String lastModifiedBy;

}
