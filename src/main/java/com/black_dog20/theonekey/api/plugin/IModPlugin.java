package com.black_dog20.theonekey.api.plugin;

import com.black_dog20.theonekey.api.keybind.IKeybindRegistration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface IModPlugin {

    /**
     * If the plugin is enabled
     * @return true if enabled, otherwise false
     */
    boolean isEnabled();

    /**
     * Register all the keybinds for the plugin
     * @param registration the keybind registration helper
     */
    void registerKeybinds(IKeybindRegistration registration);

}
