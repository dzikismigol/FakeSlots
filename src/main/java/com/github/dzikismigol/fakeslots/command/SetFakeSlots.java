package com.github.dzikismigol.fakeslots.command;

import com.github.dzikismigol.fakeslots.bus.Command;

public class SetFakeSlots implements Command {
    private int slots;

    public SetFakeSlots(int slots) {
        this.slots = slots;
    }

    public int getSlots() {
        return this.slots;
    }
}
