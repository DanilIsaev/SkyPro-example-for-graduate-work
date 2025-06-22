package ru.skypro.homework.dto.ad;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skypro.homework.entity.Ads;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ad {

    
    @Schema(description = "ID автора объявления")
    private Long author;

    
    @Schema(description = "Ссылка на картинку объявления")
    private String image;

    
    @Schema(description = "ID объявления")
    private Integer pk;

    
    @Schema(description = "Цена объявления")
    private Integer price;

    
    @Schema(description = "Заголовок объявления")
    private String title;

    
    public static Ad mapEntityToDto(Ads ad) {
        return Ad.builder()
                .title(ad.getTitle())
                .price(ad.getPrice())
                .pk(ad.getPk())
                .author(ad.getAuthor())
                .image(ad.getImage())
                .build();
    }

    
    public Ads mapDtoToEntity(String description) {
        return Ads.builder()
                .title(title)
                .price(price)
                .image(image)
                .pk(pk)
                .author(author)
                .description(description)
                .build();
    }
}