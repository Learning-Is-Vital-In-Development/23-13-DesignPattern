package command;

import java.util.HashMap;
import java.util.Map;

public class Client {

    public static void main(String[] args) {
        Light light = new Light();

        Map<RemoteControlType, Command> onCommands = new HashMap<>();

        onCommands.put(RemoteControlType.LIVING_ROOM_LIGHT, new LightOnCommand(light));
        onCommands.put(RemoteControlType.REST_ROOM_LIGHT, new LightOnCommand(light));
        onCommands.put(RemoteControlType.ROOM_LIGHT, new LightOnCommand(light));


        Map<RemoteControlType, Command> offCommands = new HashMap<>();
        offCommands.put(RemoteControlType.LIVING_ROOM_LIGHT, new LightOffCommand(light));
        offCommands.put(RemoteControlType.REST_ROOM_LIGHT, new LightOffCommand(light));
        offCommands.put(RemoteControlType.ROOM_LIGHT, new LightOffCommand(light));

        RemoteInvoker remoteInvoker = new RemoteInvoker(onCommands, offCommands);
        System.out.println("---- 방에있는 ----");
        remoteInvoker.on(RemoteControlType.ROOM_LIGHT);
        remoteInvoker.undo();
        remoteInvoker.on(RemoteControlType.ROOM_LIGHT);
        remoteInvoker.off(RemoteControlType.ROOM_LIGHT);

        System.out.println("---- 거실에 있는 ----");
        remoteInvoker.on(RemoteControlType.LIVING_ROOM_LIGHT);
        remoteInvoker.undo();
        remoteInvoker.on(RemoteControlType.LIVING_ROOM_LIGHT);
        remoteInvoker.off(RemoteControlType.LIVING_ROOM_LIGHT);

        System.out.println("---- 화장실 있는 ----");
        remoteInvoker.on(RemoteControlType.REST_ROOM_LIGHT);
        remoteInvoker.undo();
        remoteInvoker.on(RemoteControlType.REST_ROOM_LIGHT);
        remoteInvoker.off(RemoteControlType.REST_ROOM_LIGHT);
    }
}
