package com.su.enjoy.model.hotel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * ホテルテーブルのEntity
 */

@Data
@Getter
@Setter
public class Hotel {
    /** ID */
    private Integer id;

    /** 名前 */
    private String name;

    /** 画像ファイル名 */
    private String image_name;

    /** ホテルの説明 */
    private String description;

    /** 料金 */
    private Integer price;

    /** 定員 */
    private Integer capacity;

    /** 郵便番号 */
    private String postal_code;

    /** 住所 */
    private String address;

    /** 電話番号 */
    private String phone_number;

    /** 作成日時 */
    private Timestamp createdAt;

    /** 更新日時 */
    private Timestamp updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return image_name;
    }

    public void setImageName(String imageName) {
        this.image_name = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getPostalCode() {
        return postal_code;
    }

    public void setPostalCode(String postalCode) {
        this.postal_code = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
