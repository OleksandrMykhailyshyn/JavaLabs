package commands;

public class DeleteInsurance implements Command{
    Menu menu;

    public DeleteInsurance(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.deleteInsurance();
    }
}
