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

    private static Vector<Integer> timerLists = new Vector<>(); //HOLD ID OF TASKS
    public static Vector<Integer> getEntityMovementTimers() {return timerLists;}

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
        timerLists.add(getMovementTimer().getTaskId());
    }

    /**
     * Constructor for player based movements, easier to get eye direction
     * etc.
     * @param playerUUID - UUID of player, don't want to store the actual instance.
     * @param toMove - Still the entity that's being moved / animated.
     */
    public EntityMovementPath(UUID playerUUID, Entity toMove)
    {
        this.playerID = playerUUID;
        this.movingEntity = toMove;
        this.timerLists.add(getMovementTimer().getTaskId()); //Ready for cleanup
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
     * Get the bukkit task, this is initially null
     * @return The timer that shall handle the animation.
     */
    public BukkitTask getMovementTimer()
    {
        return this.movementTimer;
    }

}
