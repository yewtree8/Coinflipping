package me.mat.port.coin;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Mat
 */
public class CoinPlugin extends JavaPlugin {

    private static CoinPlugin instance;
    public static CoinPlugin getInstance() { return instance; }

    /**
     * Enable method.
     */
    public void onEnable()
    {
        instance = this;
    }



}
