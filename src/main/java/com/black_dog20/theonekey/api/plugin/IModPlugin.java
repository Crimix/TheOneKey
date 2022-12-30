package com.black_dog20.theonekey.api.plugin;

import com.black_dog20.theonekey.api.keybind.IKeybindRegistration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface IModPlugin {

    boolean isEnabled();

    void registerKeybinds(IKeybindRegistration registration);

}
