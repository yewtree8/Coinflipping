package me.mat.port.coin.engine;

import java.util.HashSet;

/**
 * @author Mat
 *
 * Used as a base to perform functions
 */
public abstract class Engine  {

    private static HashSet<Engine> allEngines = new HashSet<>();
    public static HashSet<Engine> getAllEngines() { return allEngines; }


    public Engine()
    {

        getAllEngines().add(this);
    }


}