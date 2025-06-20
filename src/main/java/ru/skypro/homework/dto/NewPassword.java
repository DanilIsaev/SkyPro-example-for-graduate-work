package ru.skypro.homework.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class NewPassword {

    
    @Schema(
            description = "Текущий пароль",
            minLength = 8,
            maxLength = 16
    )
    private String currentPassword;

    
    @Schema(
            description = "Новый пароль",
            minLength = 8,
            maxLength = 16
    )
    private String newPassword;
}