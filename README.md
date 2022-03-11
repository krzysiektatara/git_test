# How to run the test

1. Clone this repository to your local machine using the command: 
```
git clone https://github.com/krzysiektatara/git_test.git
```
2. Run the test using following command:
```
mvn clean package -DgitUser=[username] -DgitUserPassword=[password] allure:serve
```

Where:  
[username] 
= github username  
[password] = password of user
