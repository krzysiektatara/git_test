package com.epam.selenium.properties;

public final class Properties {

    public static final String GIT_HUB_LOGIN = System.getProperty("gitUser");//mvn clean package -DgitUser=$USER_NAME
    public static final String GIT_HUB_PASS = System.getProperty("gitUserPassword"); //mvn clean package -DgitUserPassword=$USER_PASSWORD
}

// mvn clean package -DgitUser=[username] -DgitUserPassword=[password]