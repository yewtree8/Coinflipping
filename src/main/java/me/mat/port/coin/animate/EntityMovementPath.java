package me.mat.port.coin.animate;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;
import java.util.Vector;


/**
 * @author Mat
 *
 * Acts as a base for moving entities (NON NMS, BUKKIT IMPORT ONLY) and their patterns
 */
public abstract class EntityMovementPath {


    private BukkitTask movementTimer;

    private UUID playerID;

    private Entity movingEntity;

    private Location location;

    /**
     * Constructor for all moving entities.
     * @param initialLocation Location of PLAYER calling it.
     * @param entity the entity that's been spawned
     */
    public EntityMovementPath(Location initialLocation, Entity entity)
    {
        this.movingEntity = entity;
        this.location = initialLocation;
    }

    /**
     * Constructor for player based movements, easier to get eye direction
     * etc.
     * @param playerUUID - UUID of player, don't want to store the actual instance.
     */
    public EntityMovementPath(UUID playerUUID)
    {
        this.playerID = playerUUID;
    }

    /**
     * Get the ORIGINAL location of where it was spawned from
     * Bukkit updates the object every time you modify it so
     * need a fresh boxed instance.
     * @return Base location.
     */
    public Location getOriginalLocation()
    {
        Location clonedLocation = location.clone();
        return clonedLocation;
    }

    /**
     * Get the target animated entity
     * @return whatever entity is going to be doing the movement.
     */
    public Entity getMovingEntity()
    {
        return this.movingEntity;
    }





    /**
     * Obviously need the UUID
     * @return UUID of player
     */
    public UUID getPlayerID()
    {
        return playerID;
    }

    /**
     * Instead of having to rebuild the player instance.
     * @return Player object that flippedf
     */
    public Player getPlayer()
    {
        return Bukkit.getPlayer(getPlayerID());
    }


}
