package com.xkings.pokemontd.component.attack.effects;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Tomas on 10/21/13.
 */
public class DotEffect extends AbstractEffect {
    private final float damage;

    public DotEffect(float interval, int iterations, float damage) {
        super(Color.RED, interval, iterations);
        this.damage = damage;
    }

    public float getDamage() {
        return damage;
    }
}