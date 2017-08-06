package com.github.dzikismigol.fakeslots.command.handler;

import com.github.dzikismigol.fakeslots.Configuration;
import com.github.dzikismigol.fakeslots.bus.Command;
import com.github.dzikismigol.fakeslots.bus.CommandHandler;
import com.github.dzikismigol.fakeslots.command.SetFakeSlots;

import javax.inject.Inject;

public class SetFakeSlotsHandler implements CommandHandler {
    private Configuration configuration;

    @Inject
    public SetFakeSlotsHandler(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public void handle(Command generic) {
        SetFakeSlots command = (SetFakeSlots) generic;
        this.configuration.setFakeSlots(command.getSlots());
    }

    @Override
    public Class getHandledCommandClass() {
        return SetFakeSlots.class;
    }
}
