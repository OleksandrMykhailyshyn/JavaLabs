package commands;

public class LogOut implements Command{
    Menu menu;

    public LogOut(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.logOut();
    }
}
