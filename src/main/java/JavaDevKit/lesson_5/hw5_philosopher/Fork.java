package JavaDevKit.lesson_5.hw5_philosopher;

import java.util.concurrent.atomic.AtomicBoolean;

public class Fork {
    private String name;
    private AtomicBoolean busy;

    public Fork(String name) {
        this.name = name;
        busy = new AtomicBoolean();
    }


    public String getName() {
        return name;
    }


    public Boolean getBusy() {
        return busy.get();
    }

    public void setBusy(Boolean busy) {
        this.busy.set(busy);
    }
}
