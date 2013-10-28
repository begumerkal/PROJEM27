package com.xkings.pokemontd.graphics.ui;

import com.artemis.Entity;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.xkings.pokemontd.App;
import com.xkings.pokemontd.component.HealthComponent;
import com.xkings.pokemontd.component.NameComponent;
import com.xkings.pokemontd.component.SpriteComponent;
import com.xkings.pokemontd.component.TowerTypeComponent;
import com.xkings.pokemontd.entity.tower.TowerName;
import com.xkings.pokemontd.entity.tower.TowerType;

import java.util.ArrayList;

/**
 * Created by Tomas on 10/8/13.
 */
class EntityInfo extends GuiBox {

    private final SpriteBatch spriteBatch;

    private final Ui ui;
    private final TowerTypeInfo towerTypeInfo;
    private final TowerEntityInfo towerEntityInfo;
    private final ArrayList<Clickable> clickables;
    private final ShopEntityInfo shopEntityInfo;
    private final ShopTypeInfo shopTypeInfo;
    private CreepEntityInfo creepEntityInfo;
    private Entity entity;
    private final BitmapFont pixelFont;

    EntityInfo(final Ui ui, Rectangle rectangle, int offset, ShapeRenderer shapeRenderer, SpriteBatch spriteBatch,
               BitmapFont font) {
        super(rectangle, offset, shapeRenderer);
        this.ui = ui;
        this.spriteBatch = spriteBatch;

        this.pixelFont = App.getAssets().getPixelFont();

        towerTypeInfo = new TowerTypeInfo(ui, offsetRectange, shapeRenderer, spriteBatch, font);
        towerEntityInfo = new TowerEntityInfo(ui, offsetRectange, shapeRenderer, spriteBatch, font);
        creepEntityInfo = new CreepEntityInfo(ui, offsetRectange, shapeRenderer, spriteBatch, font);
        shopTypeInfo = new ShopTypeInfo(ui, offsetRectange, shapeRenderer, spriteBatch, font);
        shopEntityInfo = new ShopEntityInfo(ui, offsetRectange, shapeRenderer, spriteBatch, font);

        clickables = new ArrayList<Clickable>();
        clickables.add(towerTypeInfo);
        clickables.add(towerEntityInfo);
        clickables.add(creepEntityInfo);
        clickables.add(shopTypeInfo);
        clickables.add(shopEntityInfo);
    }

    @Override
    public void render() {
        super.render();
        disableClickables();
        TowerType towerType = ui.getTowerManager().getSelectedTowerType();
        if (towerType != null) {

            if (towerType.getName().equals(TowerName.Shop)) {
                shopTypeInfo.render(towerType);
            } else {
                towerTypeInfo.render(towerType);
            }
            return;
        }

        entity = ui.getTowerManager().getClicked();
        if (entity != null) {

            if (entity.getComponent(TowerTypeComponent.class).getTowerType().getName().equals(TowerName.Shop)) {
                shopEntityInfo.render(entity);
            } else {
                towerEntityInfo.render(entity);
            }
            return;
        }

        entity = ui.getCreepManager().getClicked();
        if (entity != null) {
            creepEntityInfo.render(entity);
            return;
        }


    }

    private void disableClickables() {
        for (Clickable clickable : clickables) {
            clickable.setEnabled(false);
        }
    }

    @Override
    public void process(float x, float y) {
    }

    private void renderCreep(Entity entity) {
        SpriteComponent spriteComponent = entity.getComponent(SpriteComponent.class);
        NameComponent nameComponent = entity.getComponent(NameComponent.class);
        HealthComponent healthComponent = entity.getComponent(HealthComponent.class);
        if (spriteComponent != null && nameComponent != null && healthComponent != null) {
        }
    }


}