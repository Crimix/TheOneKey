package com.black_dog20.theonekey.client.internal;

import com.black_dog20.theonekey.api.keybind.IContext;
import com.black_dog20.theonekey.api.keybind.KeyModifier;
import net.minecraft.world.item.ItemStack;

public class Context implements IContext {

    private final KeyModifier keyModifier;
    private final ItemStack copy;

    public Context(KeyModifier keyModifier, ItemStack copy) {
        this.keyModifier = keyModifier;
        this.copy = copy;
    }

    @Override
    public KeyModifier getKeyModifier() {
        return keyModifier;
    }

    @Override
    public ItemStack getItemStackCopy() {
        return copy;
    }
}
