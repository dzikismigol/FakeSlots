package com.github.dzikismigol.fakeslots.bus;

public interface CommandBus {
    void dispatch(Command command) throws Exception;
    void addHandler(CommandHandler handler);
}
