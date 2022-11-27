package commands;

public class Register implements Command{
    Menu menu;

    public Register(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.register();
    }
}
