package com.xkings.pokemontd.system;

import com.xkings.pokemontd.component.WaveComponent;

public class GetCreep extends GetEntity {

    /**
     * Finds desired creep on giver coordinates
     */
    public GetCreep() {
        super(WaveComponent.class);
    }

}
