package model.interview;

import model.Space;

import java.util.List;

public class Room {

    private final Space room;

    public Room(Space space) {
        this.room = space;
    }

    public int getCapacity() {
        return room.getCapacity();
    }

    public List<String> getEquipments() {
        return room.getEquipments();
    }

    public String getAddress() {
        return room.getAddress();
    }

    // This check method is not included in Open-Host Service
    public void checkRoom() {
        if (!(getCapacity() >= 2)
                || !getEquipments().containsAll(List.of("PC", "Monitor"))) {
            // it's too complicated ...
            // cancel the room and find another room ? What if the new room is not appropriate again ?
            // cancel the room and raise an exception ?
            // cancel the room and generate an online interview link ?
            // many questions to ask and all depends on a system on which we don't have a control
        }
    }
}
