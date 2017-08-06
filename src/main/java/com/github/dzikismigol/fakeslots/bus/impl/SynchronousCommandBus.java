package com.github.dzikismigol.fakeslots.bus.impl;

import com.github.dzikismigol.fakeslots.bus.Command;
import com.github.dzikismigol.fakeslots.bus.CommandBus;
import com.github.dzikismigol.fakeslots.bus.CommandHandler;

import java.util.HashMap;
import java.util.Map;

public class SynchronousCommandBus implements CommandBus {
    private Map<String, CommandHandler> handlers;

    public SynchronousCommandBus() {
        this.handlers = new HashMap<>();
    }

    @Override
    public void dispatch(Command command) throws Exception {
        if (!this.handlers.containsKey(command.getClass().getCanonicalName())) {
            throw new Exception("Handler for " + command.getClass().getCanonicalName() + " is not registered");
        }

        this.handlers.get(command.getClass().getCanonicalName()).handle(command);
    }

    @Override
    public void addHandler(CommandHandler handler) {
        this.handlers.put(handler.getHandledCommandClass().getCanonicalName(), handler);
    }
}
