package com.epam.selenium.invoker.implementations.date;

import com.epam.selenium.enums.date.DateToTest;
import com.epam.selenium.properties.holder.PropertyHolder;

public class Month {
    private final String month;
    PropertyHolder propertyHolder = new PropertyHolder();

    public Month() {
        this.month = DateToTest.valueOf(propertyHolder.readProperty("month")).toString();
    }

    public String getDate() {
        return this.month;
    }

    public String getMonthName() {
        return propertyHolder.readProperty("month");
    }


}
