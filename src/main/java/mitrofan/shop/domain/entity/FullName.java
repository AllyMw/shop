package mitrofan.shop.domain.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@MappedSuperclass
public class FullName {

    private String firstName;

    private String lastName;
}