package ru.skypro.homework.dto.comment;

import java.util.Objects;

public class CreateOrUpdateCommentDTO {

    public CreateOrUpdateCommentDTO text(String text) {
        this.text = text;
        return this;
    }

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateOrUpdateCommentDTO createOrUpdateCommentDTO = (CreateOrUpdateCommentDTO) o;
        return Objects.equals(this.text, createOrUpdateCommentDTO.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateOrUpdateCommentDTO {\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
