package me.mat.port.coin;

import me.mat.port.coin.service.StartupService;
import me.mat.port.coin.service.component.Service;
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
        init(); //Set everything up.
    }

    public void onDisable()
    {
        Service.cleanServices();
    }

    private void init()
    {
        new StartupService();
    }





}
