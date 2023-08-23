package org.example.dto;

public class StaffDTO {
    private Integer id;
    private String code;
    private String name;
    private String email;
    private String departmentName;
    private String roleName;
    private Boolean status;

    public StaffDTO() {
    }

    public StaffDTO(Integer id, String code, String name, String email, String departmentName, String roleName, Boolean status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
        this.roleName = roleName;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
