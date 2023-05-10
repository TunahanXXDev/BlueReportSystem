package dev.tunahanxx.logic;

import dev.tunahanxx.files.DataFile;
import dev.tunahanxx.files.MessagesFile;
import dev.tunahanxx.files.SettingsFile;
import org.bukkit.ChatColor;

public class StopLogic {

    public static void onStopLogic () {

        try {

            System.out.println(ChatColor.translateAlternateColorCodes('&', ""));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&bBlueReportSystem &7- &dTunahanXXDev"));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&bPlugin Api Version&7: &e1.19x"));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&bPlugin Version&7: &eBETA 1.0.0"));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&bPlugin Line&7: &edev.tunahanxx.BlueReportSystem"));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&cPlugin Is Saving.."));
            System.out.println(ChatColor.translateAlternateColorCodes('&', ""));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&e&ldata.yml &7- &cHas Named File Is Saving.."));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&e&lmessages.yml &7- &cHas Named File Is Saving.."));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&e&lsettings.yml &7- &cHas Named File Is Saving.."));
            System.out.println(ChatColor.translateAlternateColorCodes('&', ""));

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DataFile.onDataFileSave();
            MessagesFile.onMessagesFileSave();
            SettingsFile.onSettingsFileSave();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}