package com.github.dzikismigol.fakeslots.bus;

public interface CommandHandler {
    void handle(Command command);
    Class getHandledCommandClass();
}
