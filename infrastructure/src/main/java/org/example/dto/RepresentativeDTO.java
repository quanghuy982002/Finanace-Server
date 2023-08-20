package org.example.dto;

public class RepresentativeDTO {
    private String name;
    private String gender;
    private String phoneNumber;
    private String position;
    private String avatarImage;

    public RepresentativeDTO() {
    }

    public RepresentativeDTO(String name, String gender, String phoneNumber, String position, String avatarImage) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.avatarImage = avatarImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }
}
