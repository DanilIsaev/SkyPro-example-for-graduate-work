package ru.skypro.homework.dto.comment;

import java.time.LocalDateTime;
import java.util.Objects;

public class CommentDTO {
    private Integer author;
    private String authorImage;
    private String authorFirstName;
    private LocalDateTime createdAt;
    private Integer pk;
    private String text;

    public CommentDTO() {
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDTO commentDTO = (CommentDTO) o;
        return Objects.equals(author, commentDTO.author) && Objects.equals(authorImage, commentDTO.authorImage) && Objects.equals(authorFirstName, commentDTO.authorFirstName) && Objects.equals(createdAt, commentDTO.createdAt) && Objects.equals(pk, commentDTO.pk) && Objects.equals(text, commentDTO.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, authorImage, authorFirstName, createdAt, pk, text);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "author=" + author +
                ", authorImage='" + authorImage + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", createdAt=" + createdAt +
                ", pk=" + pk +
                ", text='" + text + '\'' +
                '}';
    }
}