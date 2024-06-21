package org.myworkspace.MovieMania.Resources;

import lombok.*;
import org.myworkspace.MovieMania.Entities.enums.Role;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class UserResource {

    private long id;

    @NotBlank(message = "User name is Mandatory")
    private String name;

    @NotBlank(message = "password is Mandatory")
    private String password;

    private Role role;

    @NotBlank(message = "Mobile is Mandatory")
    private String mobile;

    @NotBlank(message = "Email is Mandatory")
    private String email;

    private List<TicketResource> tickets;
}
