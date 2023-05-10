package dev.tunahanxx.utils;

import dev.tunahanxx.files.DataFile;
import dev.tunahanxx.files.MessagesFile;
import dev.tunahanxx.files.SettingsFile;

public class FileUtils {

    public static void onDataFileUtils() {
        DataFile.onDataFileSetup();

        DataFile.onDataFileGet().options().copyDefaults(true);
        DataFile.onDataFileSave();
    }

    public static void onMessagesFileUtils() {
        MessagesFile.onMessagesFileSetup();

        MessagesFile.onMessagesFileGet().addDefault("Messages.Report-Message", "&aYou Reported &e&l%reported_player% &aFor &e&l%reason% &aReason.");
        MessagesFile.onMessagesFileGet().addDefault("Messages.Not-Player", "&c&lYou Are Not Player!");
        MessagesFile.onMessagesFileGet().addDefault("Messages.No-Permission", "&cYou Dont Have Permission.");
        MessagesFile.onMessagesFileGet().addDefault("Messages.Reload-Message", "&aPlugin Reload Is Succes!");

        MessagesFile.onMessagesFileGet().options().copyDefaults(true);
        MessagesFile.onMessagesFileSave();
    }

    public static void onSettingsFileUtils() {
        SettingsFile.onSettingsFileSetup();

        SettingsFile.onSettingsFileGet().addDefault("Reload-Command-Enabled", true);
        SettingsFile.onSettingsFileGet().addDefault("Report-Command-Enabled", true);
        SettingsFile.onSettingsFileGet().addDefault("Report-Command-Permission", "bluereportsystem.report");
        SettingsFile.onSettingsFileGet().addDefault("Reload-Command-Permission", "bluereportsystem.reload");

        SettingsFile.onSettingsFileGet().options().copyDefaults(true);
        SettingsFile.onSettingsFileSave();
    }
}