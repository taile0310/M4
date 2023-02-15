package com.example.spring_boot_ex1.dto;

import com.example.spring_boot_ex1.model.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class BlogDto {
    private int id;
    @NotEmpty(message = "Không đươc để trống")
    private String title;

    @NotEmpty(message = "Không đươc để trống")
    private String content;

    private Category category;

    @NotEmpty(message = "Không đươc để trống")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Tên không được chứa kí tự số")
    private String author;

    @NotEmpty(message = "Không đươc để trống")
    private String startDay;

    public BlogDto() {
    }

    public BlogDto(int id, String title, String content, Category category, String author, String startDay) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.author = author;
        this.startDay = startDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }
}
