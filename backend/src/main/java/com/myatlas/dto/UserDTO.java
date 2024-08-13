package com.myatlas.dto;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String vkId;
    private String telegramId;

    // Конструктор по умолчанию
    public UserDTO() {}

    // Полный конструктор
    public UserDTO(Long id, String name, String email, String vkId, String telegramId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.vkId = vkId;
        this.telegramId = telegramId;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVkId() {
        return vkId;
    }

    public void setVkId(String vkId) {
        this.vkId = vkId;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }
}
