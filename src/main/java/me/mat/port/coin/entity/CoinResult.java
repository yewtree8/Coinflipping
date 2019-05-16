package me.mat.port.coin.entity;

/**
 * @author Mat
 *
 * Outcome of one or the other.
 */
public enum CoinResult {

    HEADS("Heads"), TAILS("Tails");

    private String displayName;

    CoinResult(String name)
    {
        this.displayName = name;
    }

    public String getName()
    {
        return this.displayName;
    }

}
