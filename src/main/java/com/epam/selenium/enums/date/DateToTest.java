package com.epam.selenium.enums.date;

import com.epam.selenium.invoker.implementations.date.Year;

public enum DateToTest {
    JANUARY("01"),
    FEBRUARY("02"),
    MARCH("03"),
    APRIL("04"),
    MAY("05"),
    JUNE("06"),
    JULY("07"),
    AUGUST("08"),
    SEPTEMBER("09"),
    OCTOBER("10"),
    NOVEMBER("11"),
    DECEMBER("12");

    private String date;
    final String currentYear = new Year().getYear();

    DateToTest(String month) {
        this.date = currentYear + "-" + month;
    }

    public String toString() {
        return this.date;
    }
}
