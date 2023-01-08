package com.black_dog20.theonekey.api.keybind;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface IKeybindRegistration {

    /**
     * Registers key bind
     * @param item the item for the keybind
     * @param enabled a callback if the specific keybind is enabled, can be used to disabled it by config
     * @param extraFilter an extra filter besides the item equality
     * @param modifier the modifier
     * @param shortDescription the short description for the tooltip
     * @param clientHandler the handler to be called when the keybind is invoked
     */
    void registerKeybind(@Nonnull Item item, @Nonnull Supplier<Boolean> enabled, @Nonnull Predicate<ItemStack> extraFilter, @Nonnull KeyModifier modifier, @Nonnull Component shortDescription, @Nonnull Consumer<IContext> clientHandler);

    /**
     * Registers key bind
     * @param item the item for the keybind
     * @param enabled a callback if the specific keybind is enabled, can be used to disabled it by config
     * @param modifier the modifier
     * @param shortDescription the short description for the tooltip
     * @param clientHandler the handler to be called when the keybind is invoked
     */
    void registerKeybind(@Nonnull Item item, @Nonnull Supplier<Boolean> enabled, @Nonnull KeyModifier modifier, @Nonnull Component shortDescription, @Nonnull Consumer<IContext> clientHandler);

    /**
     * Registers key bind
     * @param tag the tag for the keybind that the items tag compound should contain
     * @param enabled a callback if the specific keybind is enabled, can be used to disabled it by config
     * @param extraFilter an extra filter besides the item tag compound containing the tag
     * @param modifier the modifier
     * @param shortDescription the short description for the tooltip
     * @param clientHandler the handler to be called when the keybind is invoked
     */
    void registerKeybind(@Nonnull String tag, @Nonnull Supplier<Boolean> enabled, @Nonnull Predicate<ItemStack> extraFilter, @Nonnull KeyModifier modifier, @Nonnull Component shortDescription, @Nonnull Consumer<IContext> clientHandler);

    /**
     * Registers key bind
     * @param tag the tag for the keybind that the items tag compound should contain
     * @param enabled a callback if the specific keybind is enabled, can be used to disabled it by config
     * @param modifier the modifier
     * @param shortDescription the short description for the tooltip
     * @param clientHandler the handler to be called when the keybind is invoked
     */
    void registerKeybind(@Nonnull String tag, @Nonnull Supplier<Boolean> enabled, @Nonnull KeyModifier modifier, @Nonnull Component shortDescription, @Nonnull Consumer<IContext> clientHandler);
}
