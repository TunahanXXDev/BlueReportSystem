package dev.tunahanxx.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class SettingsFile {

    private static File onSettingsFile;
    private static FileConfiguration onSettingsFileConfig;

    public static void onSettingsFileSetup() {
        onSettingsFile = new File(Bukkit.getServer().getPluginManager().getPlugin("BlueReportSystem").getDataFolder(), "settings.yml");

        if (!onSettingsFile.exists()) {
            try {
                Bukkit.getServer().getPluginManager().getPlugin("BlueReportSystem").getDataFolder().mkdirs();
                onSettingsFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        onSettingsFileConfig = YamlConfiguration.loadConfiguration(onSettingsFile);
    }

    public static FileConfiguration onSettingsFileGet() {
        return onSettingsFileConfig;
    }

    public static void onSettingsFileSave() {
        try {
            onSettingsFileConfig.save(onSettingsFile);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void onSettingsFileReload() {
        onSettingsFileConfig = YamlConfiguration.loadConfiguration(onSettingsFile);
    }
}