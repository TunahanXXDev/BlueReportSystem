package dev.tunahanxx.commands;

import dev.tunahanxx.files.DataFile;
import dev.tunahanxx.files.MessagesFile;
import dev.tunahanxx.files.SettingsFile;
import dev.tunahanxx.utils.FileReloadUtils;
import dev.tunahanxx.utils.SoundUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("ALL")

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender s,
                             @NotNull Command c,
                             @NotNull String l,
                             @NotNull String[] a) {

        if (s instanceof Player) {

            Player o = (Player) s;

            Location loc = o.getLocation();

            if (SettingsFile.onSettingsFileGet().getBoolean("Report-Command-Enabled") == true) {
                if (o.hasPermission(SettingsFile.onSettingsFileGet().getString("Report-Command-Permission"))) {
                    if (l.equalsIgnoreCase("report")) {
                        if (a.length >= 2) {

                            Player target = Bukkit.getPlayer(a[0]);
                            String reason = a[1];

                            try {
                                try {
                                    String msg = MessagesFile.onMessagesFileGet().getString("Messages.Report-Message").replaceAll("%reported_player%",
                                            target.getName().toString()).replaceAll("%reason%", reason);

                                    o.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));

                                    o.playSound(loc, SoundUtils.levelUp, 10, 1);

                                    DataFile.onDataFileGet().set("Reports.List." + o.getUniqueId().toString() + ".Reporting", o.getName());
                                    DataFile.onDataFileGet().set("Reports.List." + o.getUniqueId().toString() + ".Suspicious", target.getName().toString());
                                    DataFile.onDataFileGet().set("Reports.List." + o.getUniqueId().toString() + ".Reason", reason);

                                    DataFile.onDataFileSave();
                                    DataFile.onDataFileReload();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    o.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesFile.onMessagesFileGet().getString("Messages.No-Permission")));
                    o.playSound(loc, SoundUtils.noSound, 10, 1);
                    return true;
                }
            }

            if (SettingsFile.onSettingsFileGet().getBoolean("Reload-Command-Enabled") == true) {
                if (o.hasPermission(SettingsFile.onSettingsFileGet().getString("Reload-Command-Permission"))) {
                    if (l.equalsIgnoreCase("bluereportsystem")) {
                        if (a.length >= 1) {
                            if (a[0].equalsIgnoreCase("reload")) {

                                FileReloadUtils.onFileReloadUtils();

                                o.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesFile.onMessagesFileGet().getString("Messages.Reload-Message")));

                                o.playSound(loc, SoundUtils.levelUp, 10, 1);

                            }
                        }
                    }
                } else {
                    o.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesFile.onMessagesFileGet().getString("Messages.No-Permission")));
                    o.playSound(loc, SoundUtils.noSound, 10, 1);
                    return true;
                }
            }
        } else {
            s.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesFile.onMessagesFileGet().getString("Messages.Not-Player")));
            return true;
        }
        return true;
    }
}