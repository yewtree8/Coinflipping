package me.mat.port.coin.engine;

/**
 * @author Mat
 * Acts as a component for different engine parts.
 */
public abstract class EngineComponent {

    private Engine parentEngine;

    public EngineComponent(Engine engine)
    {
        this.parentEngine = engine;
    }

    public Engine getParentEngine()
    {
        return this.parentEngine;
    }

}
