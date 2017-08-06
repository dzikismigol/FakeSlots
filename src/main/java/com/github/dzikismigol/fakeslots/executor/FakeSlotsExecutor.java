package com.github.dzikismigol.fakeslots.executor;

import com.github.dzikismigol.fakeslots.bus.CommandBus;
import com.github.dzikismigol.fakeslots.command.SetFakeSlots;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

public class FakeSlotsExecutor implements CommandExecutor {
    private CommandBus commandBus;

    @Inject
    public FakeSlotsExecutor(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            commandSender.sendMessage(strings);
            int slots = Integer.parseInt(strings[0]);
            this.commandBus.dispatch(new SetFakeSlots(slots));
            commandSender.sendMessage("Setting fake slots to " + slots);
        } catch (Exception e) {
            commandSender.sendMessage(e.getMessage());
            return false;
        }

        return true;
    }
}
