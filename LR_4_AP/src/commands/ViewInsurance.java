package commands;

public class ViewInsurance implements Command{
    Menu menu;

    public ViewInsurance(Menu menu) {
        this.menu = menu;
    }
    @Override
    public void execute() {
        menu.viewInsurance();
    }
}
