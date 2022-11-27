package commands;

import java.io.IOException;

public class Register implements Command{
    Menu menu;

    public Register(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.register();
    }
}
