package com.learning.ecommerce.customercore.customers.internal.transport.http.representation;

import com.learning.ecommerce.customercore.customers.api.Customer;
import com.learning.ecommerce.customercore.customers.api.Gender;
import com.learning.ecommerce.customercore.customers.api.Role;

import java.util.Date;
import java.util.UUID;

public class CustomerRepresentation {

    private UUID id;

    private boolean active;

    private String username;

    private String firstName;

    private String lastName;

    private String middleName;

    private String nickname;

    private String email;

    private Gender gender;

    private String mobilePhonePrefix;

    private String mobilePhone;

    private Date birthday;

    private Role role;

    private Date updatedAt;

    private String updatedBy;

    public CustomerRepresentation(Customer customer) {
        this.id = customer.getId();
        this.active = customer.isActive();
        this.username = customer.getUsername();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.middleName = customer.getMiddleName();
        this.nickname = customer.getNickname();
        this.email = customer.getEmail();
        this.gender = customer.getGender();
        this.mobilePhonePrefix = customer.getMobilePhonePrefix();
        this.mobilePhone = customer.getMobilePhone();
        this.birthday = customer.getBirthday();
        this.role = customer.getRole();
        this.updatedAt = customer.getUpdatedAt();
        this.updatedBy = customer.getUpdatedBy();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobilePhonePrefix() {
        return mobilePhonePrefix;
    }

    public void setMobilePhonePrefix(String mobilePhonePrefix) {
        this.mobilePhonePrefix = mobilePhonePrefix;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
