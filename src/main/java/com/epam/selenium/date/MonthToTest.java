package com.epam.selenium.date;

public enum MonthToTest {
    JANUARY("2022-01"),
    FEBRUARY("2022-02"),
    APRIL("2022-03");

    private String month;

    MonthToTest(String month) {
        this.month = month;
    }

    public String toString() {
        return this.month;
    }
}
