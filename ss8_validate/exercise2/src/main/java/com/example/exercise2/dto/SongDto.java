package com.example.exercise2.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;
    @NotBlank(message = "Không được để khoảng trắng")
    @Size(min = 1,max = 800, message = "không dài quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Không được chứa kí tự đặc biệt")
    private String name;

    @NotBlank(message = "Không được để khoảng trắng")
    @Size(min = 1,max = 300, message = "không dài quá 300 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Không được chứa kí tự đặc biệt")
    private String singer;

    @NotBlank(message = "Không được để khoảng trắng")
    @Size(min = 1,max = 1000, message = "không dài quá 1000 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9,]+$", message = "Không được chứa kí tự đặc biệt trừ dấu phẩy")
    private String category;

    public SongDto(int id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public SongDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
