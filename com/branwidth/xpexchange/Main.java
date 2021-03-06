package com.branwidth.xpexchange;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        // Some text here for starting the plugin
        getLogger().info("Enabled XpExchange");
        //Creating the config file for the plugin
        createConfig();
        // Specifying commands for the plugin
        getCommand("xpexchange").setExecutor(new TestCommand());

    }

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml for XpExchange found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    // Creating a getter for the Main class
    public static Main getPlugin() {
        return Main.getPlugin(Main.class);
    }




    @Override
    public void onDisable(){
        // Some text here for stopping the plugin
        getLogger().info("Disabled XpExchange");
    }

}
