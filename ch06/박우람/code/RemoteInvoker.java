package command;

import java.util.HashMap;
import java.util.Map;

public class RemoteInvoker {
    private Map<RemoteControlType, Command> onCommands;
    private Map<RemoteControlType, Command> offCommands;
    private Command undoCommand = new NoCommand();

    public RemoteInvoker(Map<RemoteControlType, Command> onCommands,
                         Map<RemoteControlType, Command> offCommands) {
        this.onCommands = onCommands;
        this.offCommands = offCommands;
    }

    public void on(RemoteControlType type) {
        Command command = onCommands.get(type);
        command.execute();
        undoCommand = command;
    }

    public void off(RemoteControlType type) {
        Command command = offCommands.get(type);
        command.execute();
        undoCommand = command;
    }

    public void undo() {
        undoCommand.undo();
    }
}
