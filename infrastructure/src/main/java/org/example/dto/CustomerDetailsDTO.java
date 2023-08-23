package org.example.dto;

import java.util.List;

public class CustomerDetailsDTO extends CustomerDTO {
    private String phoneNumber;
    private String taxId;
    private String email;
    private String fax;
    private String address;
    private String bankAccountNumber;
    private String bankName;
    private String bankBranch;

    private String note;
    private List<RepresentativeDTO> representatives;

    public CustomerDetailsDTO() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public List<RepresentativeDTO> getRepresentatives() {
        return representatives;
    }

    public void setRepresentatives(List<RepresentativeDTO> representatives) {
        this.representatives = representatives;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
