package com.black_dog20.theonekey.api.plugin;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public @interface OneKeyPlugin {

    /**
     * The mod ids needed for the plugin to be active.
     * @return the mod ids
     */
    String[] modIds();
}
