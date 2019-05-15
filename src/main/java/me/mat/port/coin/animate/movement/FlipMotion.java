package me.mat.port.coin.animate.movement;

import me.mat.port.coin.animate.EntityMovementPath;
import me.mat.port.coin.animate.IAnimation;
import org.bukkit.entity.Entity;

import java.util.UUID;

/**
 * @author Mat
 *
 * Does the actual flipping motion itself.
 */
public class FlipMotion extends EntityMovementPath implements IAnimation {


    public FlipMotion(UUID playerID, Entity toMove)
    {
        super(playerID, toMove);
    }


    @Override
    public void beginAnimation()
    {

    }

    @Override
    public void clearAnimation()
    {
        getMovingEntity().remove(); //Clear it up.
        getMovementTimer().cancel(); //ALWAYS CLEAR
    }
}
