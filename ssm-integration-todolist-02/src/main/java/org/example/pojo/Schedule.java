package org.example.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotBlank
    private String title;
    @NotNull
    private Integer completed;
}