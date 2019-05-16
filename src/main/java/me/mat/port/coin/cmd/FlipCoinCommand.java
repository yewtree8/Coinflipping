package me.mat.port.coin.cmd;

import me.mat.port.coin.animate.movement.FlipMotion;
import me.mat.port.coin.util.Log;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Mat
 *
 * Coin flip main command.
 */
public class FlipCoinCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if(args.length==0)
            {
                player.sendMessage(ChatColor.GREEN + "Flipping the coin, what shall it land on?");
                new FlipMotion(player.getUniqueId());
            }
            else
            {
                player.sendMessage("Just do /flipcoin");
            }
        } else {
            Log.print("You may only do this in game");
        }
        return false;
    }
}
