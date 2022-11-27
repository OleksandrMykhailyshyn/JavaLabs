package commands;

import java.io.IOException;

public class UpdateInsurance implements Command{
    Menu menu;

    public UpdateInsurance(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.updateInsurance();
    }
}
