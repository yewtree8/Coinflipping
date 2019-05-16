package me.mat.port.coin.entity;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

/**
 * @author Mat
 *
 * Acts as the physical coin itself.
 * An armorstand with a daffofil on its head.
 */
public class Coin {

    private static final int NUMBER_OF_SIDES = 2;

    private ArmorStand coinStand;

    private Location startingLocation;

    private Location currentLocation;

    public Coin(Location beginLocation)
    {
        this.startingLocation = beginLocation;
        this.currentLocation = beginLocation;
        loadCoin();
    }

    /**
     * Just a simple 0 or 1 check.
     * 0 = Heads
     * 1 = Tails
     * @return
     */
    public CoinResult findResult()
    {
        Random random = new Random();
        int result = random.nextInt(NUMBER_OF_SIDES);
        return result == 0 ? CoinResult.HEADS : CoinResult.TAILS;
    }

    /**
     * Get the solid location object as to where the
     * coin initially started
     * @return
     */
    public final Location getStartingLocation()
    {
        Location cloned = this.startingLocation.clone();
        return cloned;
    }


    /**
     * Gets the "coin" or in this case
     * the empty armour stand, this is for
     * animation manipulation.
     * @return Armorstand disguised as a coin.
     */
    public ArmorStand getCoin()
    {
        return this.coinStand;
    }

    /**
     * Loads the values for the armour stand
     * that shall act like a coin.
     */
    private void loadCoin()
    {
        this.coinStand = getStartingLocation().getWorld().spawn(getStartingLocation(), ArmorStand.class);
        getCoin().setArms(false);
        getCoin().setBasePlate(false);
        getCoin().setSmall(true);
        getCoin().setGravity(false);
        getCoin().setVisible(false);
        getCoin().setHelmet(new ItemStack(Material.DOUBLE_PLANT));
    }


    /**
     * Easy method of teleporting the coin.
     * @param newLocation the next location
     */
    public void moveTo(Location newLocation)
    {
        getCoin().teleport(newLocation);
        this.currentLocation = newLocation;
    }

    /**
     * This rotates the coin as if it is flipping in the air
     * max it will go is 180 and smallest -180.
     * rotating at 25 degrees a tenth of a tick
     */
    public void rotateCoin()
    {
        float pitch = getCoin().getLocation().getPitch();
        float newPitch = pitch + 25;
        if(newPitch >= 180) //max pitch
        {
            getCoin().getLocation().setPitch(-155); //180 - 25 so it doesn't glitch
            moveTo(getCoin().getLocation());
        }
        else
        {
            Location nextLoc = getCoin().getLocation();
            nextLoc.setPitch(getCoin().getLocation().getPitch() + 25);
            moveTo(nextLoc);
        }
    }


    /**
     * Clear the coin and its little bits up
     * in order to let the GC collect it.
     */
    public void destroy()
    {
        getCoin().remove();
        startingLocation = null;
    }

}
