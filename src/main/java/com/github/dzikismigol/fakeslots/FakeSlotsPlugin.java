package com.github.dzikismigol.fakeslots;

import com.github.dzikismigol.fakeslots.bus.CommandBus;
import com.github.dzikismigol.fakeslots.bus.impl.SynchronousCommandBus;
import com.github.dzikismigol.fakeslots.command.handler.SetFakeSlotsHandler;
import com.github.dzikismigol.fakeslots.executor.FakeSlotsExecutor;
import com.github.dzikismigol.fakeslots.listener.ServerListPingListener;
import org.bukkit.plugin.java.JavaPlugin;

public class FakeSlotsPlugin extends JavaPlugin {
    protected static FakeSlotsPlugin instance;
    protected CommandBus commandBus;

    public FakeSlotsPlugin() {
        FakeSlotsPlugin.instance = this;
        this.commandBus = new SynchronousCommandBus();

        this.commandBus.addHandler(new SetFakeSlotsHandler(Configuration.getInstance()));

    }

    public static FakeSlotsPlugin getInstance() {
        return FakeSlotsPlugin.instance;
    }

    @Override
    public void onEnable() {
        this.getCommand("fakeslots").setExecutor(new FakeSlotsExecutor(this.commandBus));

        this.getServer().getPluginManager().registerEvents(new ServerListPingListener(Configuration.getInstance()), this);
    }
}
