package com.project.ToDoListApp.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RegisterEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank (message = "please enter your first-name")
    private String firstName;
    @NotBlank (message = "please enter your last-name")
    private String lastName;
    @Email (message = "please enter your valid email")
    private String email;
    @Length (min = 8, message = "field character must be minimum 8 character" )
    private String password;
    @NotBlank (message = "please enter your address")
    private String address;
    @NotBlank (message = "please enter your phone number")
    private String phoneNum;
    @NotBlank (message = "please enter reason to join this applications")
    private String reasonToJoin;



}
