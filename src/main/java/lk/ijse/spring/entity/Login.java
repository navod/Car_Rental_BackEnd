package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(value = {"requestDetails"})
public class Login {
    @Id
    private String logId;
    private String role;
    @Column(unique = true)
    private String email;
    private String password;



}
