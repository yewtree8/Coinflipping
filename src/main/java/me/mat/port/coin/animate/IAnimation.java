package me.mat.port.coin.animate;

/**
 * @author Mat
 *
 * Interface for all animations, when to begin, clear up entities
 * that may cause lag etc.
 */
public interface IAnimation {

    void beginAnimation();

    void clearAnimation();

}
