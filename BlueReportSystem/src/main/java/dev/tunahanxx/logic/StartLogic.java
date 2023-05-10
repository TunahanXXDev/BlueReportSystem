package dev.tunahanxx.logic;

import dev.tunahanxx.utils.FileUtils;
import org.bukkit.ChatColor;

public class StartLogic {

    public static void onStartLogic () {

        try {

            System.out.println(ChatColor.translateAlternateColorCodes('&', ""));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&bBlueReportSystem &7- &dTunahanXXDev"));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&bPlugin Api Version&7: &e1.19x"));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&bPlugin Version&7: &eBETA 1.0.0"));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&bPlugin Line&7: &edev.tunahanxx.BlueReportSystem"));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&aPlugin Is Loading.."));
            System.out.println(ChatColor.translateAlternateColorCodes('&', ""));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&e&ldata.yml &7- &aHas Named File Is Loading.."));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&e&lmessages.yml &7- &aHas Named File Is Loading.."));
            System.out.println(ChatColor.translateAlternateColorCodes('&', "&e&lsettings.yml &7- &aHas Named File Is Loading.."));
            System.out.println(ChatColor.translateAlternateColorCodes('&', ""));

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileUtils.onDataFileUtils();
            FileUtils.onMessagesFileUtils();
            FileUtils.onSettingsFileUtils();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}