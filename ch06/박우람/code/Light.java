package command;

public class Light {

    private boolean lightOn = false;

    public void on() {
        if (!lightOn) {
            lightOn = true;
            System.out.println("불을 켰습니다.");
        }
    }

    public void off() {
        if (lightOn) {
            lightOn = false;
            System.out.println("불을 껐습니다.");
        }
    }
}
