package com.epam.selenium.date;

public enum MonthToTest {
    JANUARY("2022-01"),
    FEBRUARY("2022-02"),
    MARCH("2022-03"),
    APRIL("2022-04");

    private String month;

    MonthToTest(String month) {
        this.month = month;
    }

    public String toString() {
        return this.month;
    }
}
