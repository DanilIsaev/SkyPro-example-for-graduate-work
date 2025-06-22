package ru.skypro.homework.dto.ad;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skypro.homework.entity.AdEntity;
import ru.skypro.homework.entity.UserEntity;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExtendedAd {

    
    @Schema(description = "ID объявления")
    private Integer pk;

    
    @Schema(description = "Имя автора объявления")
    private String authorFirstName;

    
    @Schema(description = "Фамилия автора объявления")
    private String authorLastName;

    
    @Schema(description = "Описание объявления")
    private String description;

    
    @Schema(description = "Логин автора объявления")
    private String email;

    
    @Schema(description = "Ссылка на картинку объявления")
    private String image;

    
    @Schema(description = "Телефон автора объявления")
    private String phone;

    
    @Schema(description = "Цена объявления")
    private Integer price;

    
    @Schema(description = "Заголовок объявления")
    private String title;

    
    public static ExtendedAd mapAdEntityToDto(AdEntity ad, UserEntity user) {
        return ExtendedAd.builder()
                .pk(ad.getPk())
                .description(ad.getDescription())
                .price(ad.getPrice())
                .title(ad.getTitle())
                .authorFirstName(user.getFirstName())
                .authorLastName(user.getLastName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .image(ad.getImage())
                .build();
    }
}