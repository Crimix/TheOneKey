package com.black_dog20.theonekey.client;

import com.black_dog20.theonekey.client.internal.KeybindData;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataHolder {

    private static Map<Item, KeybindData> keybindItemData = new HashMap<>();
    private static Map<String, KeybindData> keybindStringData = new HashMap<>();

    public static Optional<KeybindData> getKeybindDataForItem(Item item) {
        return Optional.ofNullable(keybindItemData.get(item));
    }

    public static Optional<KeybindData> getKeybindDataForTag(String tag) {
        return Optional.ofNullable(keybindStringData.get(tag));
    }
}
