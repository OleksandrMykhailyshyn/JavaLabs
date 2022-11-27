package menu;

import commands.Command;
import user.User;

import java.util.HashMap;

public class DoMenu {
    HashMap<Integer, Command> doMenu = new HashMap<>();

    public DoMenu(User user) {
        doMenu.put(1,user.getSelect());
        doMenu.put(2,user.getUpdate());
        doMenu.put(3,user.getDelete());
        doMenu.put(4,user.getHelp());
        doMenu.put(5,user.getView());
        doMenu.put(6,user.getLogOut());
    }

    public HashMap<Integer, Command> getDoMenu() {
        return doMenu;
    }
}
