package org.example.terminal;

import org.example.business.ViewLogin;
import org.example.dao.ViewLoginDAO;

import java.util.List;

public class Login extends Terminal{
    public List<ViewLogin> loginForm() {

        String login;
        String senha;

        do {
            login = "";
            senha = "";

            System.out.println("Login no Sistema");

            System.out.print("Email -> ");
            login = inputString.nextLine();

            System.out.print("Senha -> ");
            senha = inputString.nextLine();

        } while (verificarLogin(login, senha).isEmpty());

        System.out.println("Acesso Concebido!");
        return verificarLogin(login, senha);
    }

    public List<ViewLogin> verificarLogin(String login, String senha) {

        ViewLoginDAO viewLogin = new ViewLoginDAO();
        return viewLogin.login(login,senha);

    }


}
