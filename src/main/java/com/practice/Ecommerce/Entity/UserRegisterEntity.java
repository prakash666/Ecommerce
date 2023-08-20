package com.practice.Ecommerce.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRegisterEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Enter first-name")
    private String firstName;
    @NotBlank(message = "Enter last-name")
    private String lastName;
    @NotBlank (message = "Enter email")
    @Column (unique = true)
    private String email;
    @Size(min= 8)
    private String password;
    @NotBlank (message = "Enter address")
    private String address;
    @NotBlank (message = "Enter age")
    private String age;
    @Column (unique = true)
    @NotBlank(message = "Enter your own number")
    private String userPhoneNumber;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) // Mapping database table and joining two tables
    @JoinTable(name="User_Roles",  // now it will create the table third table called Roles in Database, it will hold User_id and Role_id
            joinColumns = {
            @JoinColumn(name = "user_id")  //
            },
                inverseJoinColumns = {
            @JoinColumn(name="role_id")
                }
    )
    private Set<RoleEntity> role; // Set is used here because user can have different roles according to assigned roles thats why Set is used, why specifically set because in Set each value should be unique
}
