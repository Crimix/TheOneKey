package com.black_dog20.theonekey.client.internal;

import com.black_dog20.theonekey.api.keybind.IContext;
import com.black_dog20.theonekey.api.keybind.IKeybindRegistration;
import com.black_dog20.theonekey.api.keybind.KeyModifier;
import com.black_dog20.theonekey.client.DataHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class KeybindRegistration implements IKeybindRegistration {

    @Override
    public void registerKeybind(@NotNull Item item, @NotNull Supplier<Boolean> enabled, @NotNull Predicate<ItemStack> extraFilter, @NotNull KeyModifier modifier, @NotNull Component shortDescription, @NotNull Consumer<IContext> clientHandler) {
        DataHolder.addKeybindForItem(item, new Keybind(modifier, enabled, extraFilter, shortDescription, clientHandler));
    }

    @Override
    public void registerKeybind(@NotNull Item item, @NotNull Supplier<Boolean> enabled, @NotNull KeyModifier modifier, @NotNull Component shortDescription, @NotNull Consumer<IContext> clientHandler) {
        registerKeybind(item, enabled, (i) -> true, modifier, shortDescription, clientHandler);
    }

    @Override
    public void registerKeybind(@NotNull String tag, @NotNull Supplier<Boolean> enabled, @NotNull Predicate<ItemStack> extraFilter, @NotNull KeyModifier modifier, @NotNull Component shortDescription, @NotNull Consumer<IContext> clientHandler) {
        DataHolder.addKeybindForTag(tag, new Keybind(modifier, enabled, extraFilter, shortDescription, clientHandler));
    }

    @Override
    public void registerKeybind(@NotNull String tag, @NotNull Supplier<Boolean> enabled, @NotNull KeyModifier modifier, @NotNull Component shortDescription, @NotNull Consumer<IContext> clientHandler) {
        registerKeybind(tag, enabled, (i) -> true, modifier, shortDescription, clientHandler);
    }
}
