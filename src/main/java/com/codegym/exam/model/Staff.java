package com.codegym.exam.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")
    private String date;

    private String gender;

    @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})")
    private String phoneNumber;

    private String cmndNumber;

    @Email
    private String email;

    @NotEmpty
    private String address;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Staff() {
    }

    public Staff(@NotEmpty String name, @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$") String date, String gender, @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})") String phoneNumber, String cmndNumber, @Email String email, @NotEmpty String address, Group group) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.cmndNumber = cmndNumber;
        this.email = email;
        this.address = address;
        this.group = group;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getCmndNumber() {
        return cmndNumber;
    }

    public void setCmndNumber(String cmndNumber) {
        this.cmndNumber = cmndNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
