package ru.skypro.homework.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ads")
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int price;
    private String title;
    private String description;
    @Getter
    private String image; // Assuming image is stored as a String path or URL

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users author;

    public Ads(int price, String title, String description, String image, Users author) {
        this.price = price;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
    }

}