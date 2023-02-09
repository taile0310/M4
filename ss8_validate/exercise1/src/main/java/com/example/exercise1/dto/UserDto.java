package com.example.exercise1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class UserDto implements Validator {
    private int id;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Không được là khoảng trắng")
    private String firstName;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Không được là khoảng trắng")
    private String lastName;

    @Pattern(regexp = "(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})\\b", message = "Số điện thoaị chưa đúng định dạng")
    private String phoneNumber;
    private int age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email chưa đúng định dạng")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        // CUSTOMER VALIDATE
        UserDto userDto = (UserDto) target;

        int age = userDto.getAge();
        // VALIDATE TUỔI
        if (age <= 0) {
            errors.rejectValue("age", "Tuổi phải lớn hơn 0", "Tuổi phải lớn hơn 0");
        }
    }
}
