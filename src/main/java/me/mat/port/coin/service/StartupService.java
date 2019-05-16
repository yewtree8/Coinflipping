package me.mat.port.coin.service;

import me.mat.port.coin.CoinPlugin;
import me.mat.port.coin.cmd.FlipCoinCommand;
import me.mat.port.coin.service.component.IService;
import me.mat.port.coin.service.component.Service;
import org.bukkit.event.Listener;

/**
 * @author Mat
 *
 * Does everything needed on startup.
 */
public class StartupService extends Service {

    public StartupService()
    {
        super();
    }

    @Override
    public void initService()
    {
        registerListeners();
    }

    /**
     * Register Listeners
     * LOAD ALL LISTENER INSTANCES INTO THE ARRAY
     */
    private void registerListeners()
    {
        Listener[] listeners = {}; //Document them here in a box to save memory.
        for(Listener listener : listeners)
        {
            CoinPlugin.getInstance().getServer().getPluginManager().registerEvents(listener, CoinPlugin.getInstance());
        }
    }



}
