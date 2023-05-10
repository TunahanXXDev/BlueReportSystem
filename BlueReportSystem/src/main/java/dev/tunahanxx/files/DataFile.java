package dev.tunahanxx.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataFile {

    private static File onDataFile;
    private static FileConfiguration onDataFileConfig;

    public static void onDataFileSetup() {
        onDataFile = new File(Bukkit.getServer().getPluginManager().getPlugin("BlueReportSystem").getDataFolder(), "data.yml");

        if (!onDataFile.exists()) {
            try {
                Bukkit.getServer().getPluginManager().getPlugin("BlueReportSystem").getDataFolder().mkdirs();
                onDataFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        onDataFileConfig = YamlConfiguration.loadConfiguration(onDataFile);
    }

    public static FileConfiguration onDataFileGet() {
        return onDataFileConfig;
    }

    public static void onDataFileSave() {
        try {
            onDataFileConfig.save(onDataFile);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void onDataFileReload() {
        onDataFileConfig = YamlConfiguration.loadConfiguration(onDataFile);
    }
}