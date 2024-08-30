package net.learning.spring.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmplyoeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
