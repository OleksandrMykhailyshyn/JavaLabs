package commands;

import java.io.IOException;

public class DeleteInsurance implements Command{
    Menu menu;

    public DeleteInsurance(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.deleteInsurance();
    }
}
