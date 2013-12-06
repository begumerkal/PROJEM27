package com.pixelthieves.pokemontd.graphics.tutorial.task;

import com.badlogic.gdx.math.Rectangle;
import com.pixelthieves.pokemontd.App;
import com.pixelthieves.pokemontd.graphics.tutorial.Notice;
import com.pixelthieves.pokemontd.graphics.tutorial.Tutorial;
import com.pixelthieves.pokemontd.graphics.ui.Ui;


/**
 * Created by Tomas on 12/2/13.
 */
public class TriggerFreeElement extends RebuildableNoticeTask {

    private Rectangle shop;

    public TriggerFreeElement(Tutorial tutorial) {
        super(tutorial);
    }

    @Override
    protected boolean needRebuild() {
        return shop != tutorial.getShopRectangle();
    }

    @Override
    protected Notice buildNotice() {
        Ui ui = tutorial.getUi();
        shop = tutorial.getShopRectangle();
        return new Notice(ui, shop != null ? shop : new Rectangle(), Notice.Orientation.BOTTOM_RIGHT,
                "Click on the shop tower", Notice.Placement.RELATIVE);
    }

    @Override
    public boolean checkConditions(App entity) {
        return entity.getPlayer().getFreeElements() > 0 && tutorial.getShop() != null;
    }

}