package com.black_dog20.theonekey.api.keybind;

import net.minecraft.world.item.ItemStack;

public interface IContext {

    /**
     * Gets the key modifier.
     * @return the key modifier
     */
    KeyModifier getKeyModifier();

    /**
     * Gets the item stack copy.
     * @return the item stack copy
     */
    ItemStack getItemStackCopy();
}
