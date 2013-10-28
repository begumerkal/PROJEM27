package com.xkings.pokemontd.graphics.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.xkings.pokemontd.entity.tower.TowerType;

/**
 * User: Seda
 * Date: 24.10.13
 * Time: 20:08
 */

public class TowerTypeInfo extends TowerInfo {

    TowerTypeInfo(final Ui ui, Rectangle rectangle, ShapeRenderer shapeRenderer, SpriteBatch spriteBatch,
                  BitmapFont font) {
        super(ui, rectangle, shapeRenderer, spriteBatch, font);
    }

    public void render(TowerType tower) {
        render(tower.getTexture(), "Dmg: " + (int) tower.getDamage(), "Spd: " + (int) tower.getSpeed(),
                "Rng: " + (int) tower.getRange(), tower.getCost(), (tower.getName().toString()), false, true);
    }

}
