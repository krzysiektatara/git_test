
1. Clone this repository to your local machine using the command:
```
git clone https://github.com/krzysiektatara/git_test.git
```
2. In src/test/resources/allure.properties chose webDriver (chrome or firefox), month, and year
```
browser=local_[firefox/chrome]
month=[MONTH] - must be capitalized
year=[year]
```

3. Run the test using following command:
```
mvn clean package -DgitUser=[username] -DgitUserPassword=[password] allure:serve
```

Where:  
[username]
= github username  
[password] = password of user
