package io.github.lasercar.spectatetp;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpectateTP extends JavaPlugin implements Listener {

    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    public String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public String deny_message = colorize(this.getConfig().getString("deny-message"));

    @EventHandler
    public void onTp(PlayerTeleportEvent event) {

        Player player = event.getPlayer();
        PlayerTeleportEvent.TeleportCause cause = event.getCause();

        if (cause.toString().equals("SPECTATE")) {
            if (!player.hasPermission("spectatetp.tp")) {
                event.setCancelled(true);
                player.sendMessage(deny_message);
            }
        }

    }

}
