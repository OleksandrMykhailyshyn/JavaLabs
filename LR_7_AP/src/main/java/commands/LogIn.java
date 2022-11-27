package commands;

import user.User;

import java.io.IOException;
import java.util.ArrayList;

public class LogIn implements Command{
    Menu menu;

    public LogIn(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.logIn();
    }
}
