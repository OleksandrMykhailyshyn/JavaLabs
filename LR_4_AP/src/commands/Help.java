package commands;

public class Help implements  Command{
    Menu menu;

    public Help(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.help();
    }
}
