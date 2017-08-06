package com.github.dzikismigol.fakeslots.listener;

import com.github.dzikismigol.fakeslots.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import javax.inject.Inject;

public class ServerListPingListener implements Listener {
    private Configuration configuration;

    @Inject
    public ServerListPingListener(Configuration configuration) {
        this.configuration = configuration;
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        int slots = this.configuration.getFakeSlots();

        event.setMaxPlayers(slots);
    }
}
