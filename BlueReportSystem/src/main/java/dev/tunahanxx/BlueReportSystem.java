package dev.tunahanxx;

import dev.tunahanxx.commands.CommandManager;
import dev.tunahanxx.logic.StartLogic;
import dev.tunahanxx.logic.StopLogic;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlueReportSystem extends JavaPlugin {

    public static BlueReportSystem i;

    @Override
    public void onEnable() {

        StartLogic.onStartLogic();

        i = this;

        onCommandLoader();

    }

    @Override
    public void onDisable() {
        StopLogic.onStopLogic();
    }

    public void onCommandLoader() {
        this.getCommand("report").setExecutor(new CommandManager());
        this.getCommand("bluereportsystem").setExecutor(new CommandManager());
    }
}