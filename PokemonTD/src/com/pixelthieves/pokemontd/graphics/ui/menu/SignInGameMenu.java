package com.pixelthieves.pokemontd.graphics.ui.menu;

import com.badlogic.gdx.math.Rectangle;
import com.pixelthieves.pokemontd.graphics.ui.Button;

/**
 * Created by Tomas on 11/19/13.
 */
class SignInGameMenu extends SignInCommonMenu {

    private final Button pause;

    SignInGameMenu(final Menu menu, Rectangle rectangle, int count) {
        super(menu, rectangle, true, count);
        pause = new MenuButton(menu, rects.get(0)) {
            @Override
            public void process(float x, float y) {
                menu.getApp().freeze(!menu.getApp().isFreezed());
            }
        };

        register(pause);
    }

    @Override
    public void render() {
        super.render();
        pause.render(menu.getApp().isFreezed() ? "RESUME" : "PAUSE");
    }
}