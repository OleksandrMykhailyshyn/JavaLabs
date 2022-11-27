package commands;

public class UpdateInsurance implements Command{
    Menu menu;

    public UpdateInsurance(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.updateInsurance();
    }
}
