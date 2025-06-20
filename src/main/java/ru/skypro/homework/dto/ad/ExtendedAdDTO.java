package ru.skypro.homework.dto.ad;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

/**
 * ExtendedAd
 */
@Validated
public class ExtendedAdDTO {
  @JsonProperty("pk")
  private Integer pk = null;

  @JsonProperty("authorFirstName")
  private String authorFirstName = null;

  @JsonProperty("authorLastName")
  private String authorLastName = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("price")
  private Integer price = null;

  @JsonProperty("title")
  private String title = null;

  public ExtendedAdDTO pk(Integer pk) {
    this.pk = pk;
    return this;
  }

  /**
   * id объявления
   * @return pk
   **/

    public Integer getPk() {
    return pk;
  }

  public void setPk(Integer pk) {
    this.pk = pk;
  }

  public ExtendedAdDTO authorFirstName(String authorFirstName) {
    this.authorFirstName = authorFirstName;
    return this;
  }

  /**
   * имя автора объявления
   * @return authorFirstName
   **/

    public String getAuthorFirstName() {
    return authorFirstName;
  }

  public void setAuthorFirstName(String authorFirstName) {
    this.authorFirstName = authorFirstName;
  }

  public ExtendedAdDTO authorLastName(String authorLastName) {
    this.authorLastName = authorLastName;
    return this;
  }

  /**
   * фамилия автора объявления
   * @return authorLastName
   **/

    public String getAuthorLastName() {
    return authorLastName;
  }

  public void setAuthorLastName(String authorLastName) {
    this.authorLastName = authorLastName;
  }

  public ExtendedAdDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * описание объявления
   * @return description
   **/

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ExtendedAdDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * логин автора объявления
   * @return email
   **/

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ExtendedAdDTO image(String image) {
    this.image = image;
    return this;
  }

  /**
   * ссылка на картинку объявления
   * @return image
   **/

    public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public ExtendedAdDTO phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * телефон автора объявления
   * @return phone
   **/

    public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public ExtendedAdDTO price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * цена объявления
   * @return price
   **/

    public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public ExtendedAdDTO title(String title) {
    this.title = title;
    return this;
  }

  /**
   * заголовок объявления
   * @return title
   **/
    public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtendedAdDTO extendedAdDTO = (ExtendedAdDTO) o;
    return Objects.equals(this.pk, extendedAdDTO.pk) &&
        Objects.equals(this.authorFirstName, extendedAdDTO.authorFirstName) &&
        Objects.equals(this.authorLastName, extendedAdDTO.authorLastName) &&
        Objects.equals(this.description, extendedAdDTO.description) &&
        Objects.equals(this.email, extendedAdDTO.email) &&
        Objects.equals(this.image, extendedAdDTO.image) &&
        Objects.equals(this.phone, extendedAdDTO.phone) &&
        Objects.equals(this.price, extendedAdDTO.price) &&
        Objects.equals(this.title, extendedAdDTO.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pk, authorFirstName, authorLastName, description, email, image, phone, price, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtendedAd {\n");

    sb.append("    pk: ").append(toIndentedString(pk)).append("\n");
    sb.append("    authorFirstName: ").append(toIndentedString(authorFirstName)).append("\n");
    sb.append("    authorLastName: ").append(toIndentedString(authorLastName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}