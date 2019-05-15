package me.mat.port.coin.service;

import me.mat.port.coin.CoinPlugin;
import me.mat.port.coin.cmd.FlipCoinCommand;
import me.mat.port.coin.service.component.IService;
import me.mat.port.coin.service.component.Service;

/**
 * @author Mat
 *
 * Does everything needed on startup.
 */
public class StartupService extends Service {

    public StartupService()
    {
        initService();
    }

    @Override
    public void initService()
    {
        registerListeners();
        registerCommands();
    }

    private void registerListeners()
    {

    }

    private void registerCommands()
    {
        CoinPlugin pl = CoinPlugin.getInstance();
        pl.getCommand("flipcoin").setExecutor(new FlipCoinCommand());
    }

}
