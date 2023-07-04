package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
        //RandomPasswordGenerator에 대한 import 필요 없음 : 의존도 낮다, 느슨한 결합가능!

        String password = passwordGenerator.generatePassword();
        if (password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
