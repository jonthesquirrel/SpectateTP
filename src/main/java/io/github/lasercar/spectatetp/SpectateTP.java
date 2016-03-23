package io.github.lasercar.spectatetp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpectateTP extends JavaPlugin implements Listener {

    public String deny_message;

    public void onEnable() {
        configInit();
        getServer().getPluginManager().registerEvents(this, this);
    }

    public String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public void configInit() {
        this.getConfig().addDefault("deny-message", "&cYou don't have permission to teleport using spectate.");
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        deny_message = colorize(this.getConfig().getString("deny-message"));
    }

    public void configReload() {
        this.reloadConfig();
        configInit();
    }

    @EventHandler
    public void onTp(PlayerTeleportEvent event) {

        Player player = event.getPlayer();
        PlayerTeleportEvent.TeleportCause cause = event.getCause();

        if (cause.toString().equals("SPECTATE")) {
            if (!player.hasPermission("spectatetp.tp")) {
                event.setCancelled(true);
                if (!deny_message.equals("")) {
                    player.sendMessage(deny_message);
                }
            }
        }

    }

    @EventHandler
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("spectatetp-reload")) {
            configReload();
            sender.sendMessage("[SpectateTP] §aconfig reloaded!");
        }

        return true;
    }

}
