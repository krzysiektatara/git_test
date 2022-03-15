package com.epam.selenium.date;

import com.epam.selenium.properties.holder.PropertyHolder;

public class Month {
    PropertyHolder propertyHolder = new PropertyHolder();
    private final String month;

    public Month() {
        this.month = MonthToTest.valueOf(propertyHolder.readProperty("month")).toString();
    }

    public String getMonth() {
        return this.month;
    }

    public String getMonthName(){
        return propertyHolder.readProperty("month");
    }


}
