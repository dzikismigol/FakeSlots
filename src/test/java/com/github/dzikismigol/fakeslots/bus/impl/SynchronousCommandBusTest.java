package com.github.dzikismigol.fakeslots.bus.impl;

import com.github.dzikismigol.fakeslots.bus.Command;
import com.github.dzikismigol.fakeslots.bus.CommandBus;
import com.github.dzikismigol.fakeslots.bus.CommandHandler;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SynchronousCommandBusTest {

    @Test
    public void testExceptionIsThrownWhenNoHandlerFound() {
        CommandBus bus = new SynchronousCommandBus();
        try {
            bus.dispatch(new DummyCommand());
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("is not registered"));
        }
    }

    @Test
    public void testHandlerIsCalled() {
        CommandBus bus = new SynchronousCommandBus();
        bus.addHandler(new DummyHandler());
        try {
            bus.dispatch(new DummyCommand());
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    private class DummyHandler implements CommandHandler {
        @Override
        public void handle(Command command) {
        }

        @Override
        public Class getHandledCommandClass() {
            return DummyCommand.class;
        }
    }

    private class DummyCommand implements Command {
    }

}