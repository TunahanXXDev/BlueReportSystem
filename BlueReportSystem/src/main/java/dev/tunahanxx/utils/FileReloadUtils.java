package dev.tunahanxx.utils;

import dev.tunahanxx.files.DataFile;
import dev.tunahanxx.files.MessagesFile;
import dev.tunahanxx.files.SettingsFile;

public class FileReloadUtils {

    public static void onFileReloadUtils() {

        try {
            DataFile.onDataFileReload();
            MessagesFile.onMessagesFileReload();
            SettingsFile.onSettingsFileReload();

            DataFile.onDataFileSave();
            MessagesFile.onMessagesFileSave();
            SettingsFile.onSettingsFileSave();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}