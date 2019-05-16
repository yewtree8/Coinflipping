package me.mat.port.coin.animate.movement;

import me.mat.port.coin.CoinPlugin;
import me.mat.port.coin.animate.EntityMovementPath;
import me.mat.port.coin.animate.IAnimation;
import me.mat.port.coin.entity.Coin;
import me.mat.port.coin.entity.CoinResult;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.UUID;

/**
 * @author Mat
 *
 * Does the actual flipping motion itself.
 *
 * Handles the "flip" in a sense
 */
public class FlipMotion extends EntityMovementPath implements IAnimation {

    private Coin theCoin;

    private CoinResult flipResult;
    private BukkitTask movementTimer;

    public FlipMotion(UUID playerID)
    {
        super(playerID);
        beginAnimation();
    }


    /**
     * Starts the animation process.
     */
    @Override
    public void beginAnimation()
    {
        final Location beginningPoint = findStartLocation();
        this.theCoin = new Coin(beginningPoint);
        this.flipResult = getCoin().findResult(); //Get the result
        beginFlipping();
    }

    /**
     * Clears the left over stuff for the GC to
     * collect.
     */
    @Override
    public void clearAnimation()
    {
        getCoin().destroy(); //Clear it up.
        movementTimer.cancel(); //ALWAYS CLEAR
        theCoin = null;
    }




    /**
     * Flipping animation method
     *
     * takes 2.5 seconds to flip, should go up and down like
     * a normal coin, landing on the floor.
     *
     * Executes method every 2 ticks, (0.1 seconds)
     */
    private int frameCount = 0;
    private void beginFlipping()
    {
        float animationTotalSecs = 2.5f;
        float totalFrames = ( (2 * 10) * 3) + (2 * 10); //total frames at one tenth of a tick
        float halfPoint = totalFrames / 2;
        float totalBlocksToTravel = 3;
        float spacesMovedPerTick = ( ( ( (totalFrames / animationTotalSecs) / totalBlocksToTravel ) / 6 ) / 10 ) / 3;
        movementTimer = new BukkitRunnable() {

            public void run()
            {
                frameCount++;
                Location currentCoinLocation;
                if(frameCount >= totalFrames) //Just to stop
                {
                    getPlayer().sendMessage(ChatColor.AQUA + "Seems like it landed on " + getCoin().findResult().getName());
                    clearAnimation();
                    return; //if the timer has run its course stop
                }


                if(frameCount <= halfPoint) //going up
                {
                    currentCoinLocation = getCoin().getCoin().getLocation().add(0, spacesMovedPerTick, 0);
                    getCoin().moveTo(currentCoinLocation);
                    getCoin().rotateCoin(); //Rotate the coin
                }
                else //going back down.
                {
                    currentCoinLocation = getCoin().getCoin().getLocation().subtract(0, spacesMovedPerTick, 0);
                    getCoin().moveTo(currentCoinLocation);
                    getCoin().rotateCoin(); //Rotate the coin
                }
                //find the new location

            }

        }.runTaskTimer(CoinPlugin.getInstance(), 0, 1L);
    }


    /**
     * Figure out where to initially place the coin
     * tiny bit of vector stuff
     * @return the coin spawnpoint.
     */
    private Location findStartLocation()
    {
        Location loc = getPlayer().getEyeLocation(); //Get the eye loc
        Vector eyeDirection = getPlayer().getLocation().getDirection(); //Get the direction
        Location inFrontOf = loc.add(eyeDirection); //Get the block in front of the players eye.
        inFrontOf.subtract(0, 1.35, 0); //Go down a block so it's by the feet
        return inFrontOf;
    }

    /**
     * Get the bukkit task, this is initially null
     * @return The timer that shall handle the animation.
     */
    public BukkitTask getMovementTimer()
    {
        return this.movementTimer;
    }

    public Coin getCoin()
    {
        return this.theCoin;
    }

    public CoinResult getFlipResult()
    {
        return this.flipResult;
    }

}
