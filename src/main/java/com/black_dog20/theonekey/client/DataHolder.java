package com.black_dog20.theonekey.client;

import com.black_dog20.theonekey.api.keybind.IContext;
import com.black_dog20.theonekey.client.internal.Keybind;
import com.black_dog20.theonekey.client.internal.KeybindData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class DataHolder {

    private static Map<Item, KeybindData> keybindItemData = new ConcurrentHashMap<>();
    private static Map<String, KeybindData> keybindStringData = new ConcurrentHashMap<>();

    public static void addKeybindForItem(Item item, Keybind keybind) {
        KeybindData keybindData = keybindItemData.computeIfAbsent(item, (k) -> new KeybindData());
        keybindData.addKeybind(keybind);
    }

    public static void addKeybindForTag(String tag, Keybind keybind) {
        KeybindData keybindData = keybindStringData.computeIfAbsent(tag, (k) -> new KeybindData());
        keybindData.addKeybind(keybind);
    }

    public static Optional<Keybind> getKeybindForItem(Item item, IContext context) {
        return Optional.ofNullable(keybindItemData.get(item))
                .flatMap(keybindData -> keybindData.getKeybindForContext(context));
    }

    public static Optional<Keybind> getKeybindForTag(String tag, IContext context) {
        return Optional.ofNullable(keybindStringData.get(tag))
                .flatMap(keybindData -> keybindData.getKeybindForContext(context));
    }

    public static Optional<Keybind> getKeybindForContext(IContext context) {
        ItemStack stack = context.getItemStackCopy();
        Item item = context.getItemStackCopy().getItem();
        Optional<Keybind> keybind = getKeybindForItem(item, context);
        if (keybind.isPresent()) {
            return keybind;
        }

        for (String key : stack.getOrCreateTag().getAllKeys()) {
           keybind = getKeybindForTag(key, context);
            if (keybind.isPresent()) {
                return keybind;
            }
        }
        return Optional.empty();
    }
}
