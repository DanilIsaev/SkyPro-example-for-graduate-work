
package ru.skypro.homework.dto.ad;

import lombok.Data;

@Data
public class CreateOrUpdateAd {
    private String title;
    private Integer price;
    private String description;
}
