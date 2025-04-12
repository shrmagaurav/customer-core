package com.learning.ecommerce.customercore.customers.api;

import java.util.Date;
import java.util.UUID;

public interface Customer {

    public UUID getId();

    public boolean isActive();

    public String getUsername();

    public String getFirstName();

    public String getLastName();

    public String getMiddleName();

    public String getNickname();

    public String getEmail();

    public Gender getGender();

    public Role getRole();

    public String getMobilePhonePrefix();

    public String getMobilePhone();

    public Date getBirthday();

    public Date getUpdatedAt();

    public String getUpdatedBy();

}
