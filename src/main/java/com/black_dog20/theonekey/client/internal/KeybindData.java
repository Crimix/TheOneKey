package com.black_dog20.theonekey.client.internal;

import com.black_dog20.theonekey.api.keybind.IContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KeybindData {

    private List<Keybind> keybinds = new ArrayList<>();

    public void addKeybind(Keybind keybind) {
        keybinds.add(keybind);
    }

    public Optional<Keybind> getKeybindForContext(IContext context) {
        return keybinds.stream()
                .filter(Keybind::isEnabled)
                .filter(key -> key.matchKeyModifier(context))
                .filter(key -> key.extraFilterMatches(context))
                .findFirst();
    }
}
