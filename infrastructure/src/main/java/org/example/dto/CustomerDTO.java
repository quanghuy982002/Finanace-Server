package org.example.dto;

public class CustomerDTO
{
    private Long id;

    private String code;
    private String name;
    private String status;
    private String groupName;
    private String avatarImage;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String code, String name, String status, String groupName, String avatarImage) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.status = status;
        this.groupName = groupName;
        this.avatarImage = avatarImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }
}
