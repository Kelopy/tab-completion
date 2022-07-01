package me.kelopy.autotab;

import me.kelopy.autotab.commands.murder;
import org.bukkit.plugin.java.JavaPlugin;

public final class AUTOTAB extends JavaPlugin {

    private static AUTOTAB instance;

    @Override
    public void onEnable() {
        System.out.println("Auto tabbing has been initiated!");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        instance = this;

        getCommand("murder").setExecutor(new murder());
        //getCommand("murder").setTabCompleter(new murderTab());
    }

    public static AUTOTAB getInstance(){
        return instance;
    }

}
