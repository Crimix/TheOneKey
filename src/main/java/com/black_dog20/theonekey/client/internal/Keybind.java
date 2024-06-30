package com.black_dog20.theonekey.client.internal;

import com.black_dog20.bml.utils.keybinds.KeybindsUtil;
import com.black_dog20.bml.utils.text.TextComponentBuilder;
import com.black_dog20.bml.utils.text.TextUtil;
import com.black_dog20.theonekey.api.keybind.IContext;
import com.black_dog20.theonekey.api.keybind.KeyModifier;
import com.black_dog20.theonekey.client.keybinds.Keybinds;
import com.black_dog20.theonekey.common.utils.Translations;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Keybind {

    private final KeyModifier keyModifier;
    private final Supplier<Boolean> enabled;
    private final Predicate<ItemStack> extraFilter;
    private final Component shortDescription;
    private final Consumer<IContext> clientHandler;

    public Keybind(KeyModifier keyModifier, Supplier<Boolean> enabled, Predicate<ItemStack> extraFilter, Component shortDescription, Consumer<IContext> clientHandler) {
        this.keyModifier = keyModifier;
        this.enabled = enabled;
        this.extraFilter = extraFilter;
        this.shortDescription = shortDescription;
        this.clientHandler = clientHandler;
    }

    public boolean isEnabled() {
        return Boolean.TRUE.equals(enabled.get());
    }

    public boolean matchKeyModifier(IContext context) {
        return keyModifier == context.getKeyModifier();
    }

    public boolean extraFilterMatches(IContext context) {
        return extraFilter.test(context.getItemStackCopy());
    }

    public void execute(IContext context) {
        clientHandler.accept(context);
    }

    public Component getTooltip() {
        return createToolTip(shortDescription);
    }

    private Component createToolTip(Component shortDescription) {
        if (keyModifier == KeyModifier.NONE) {
            return getBasicTooltip(shortDescription);
        } else {
            return getTwoKeyTooltip(shortDescription);
        }
    }

    private Component getBasicTooltip(Component shortDescription) {
        return TextComponentBuilder.of(KeybindsUtil.getKeyBindText(Keybinds.keyOneKey))
                .format(ChatFormatting.GOLD).space()
                .with(Translations.TOOLTIP_TO)
                .format(ChatFormatting.GRAY).space()
                .with(shortDescription)
                .format(ChatFormatting.GRAY)
                .build();
    }

    private Component getTwoKeyTooltip(Component shortDescription) {
        return TextComponentBuilder.of(getKeyFromModifier())
                .format(ChatFormatting.GOLD).space()
                .with("+")
                .format(ChatFormatting.GOLD).space()
                .with(KeybindsUtil.getKeyBindText(Keybinds.keyOneKey))
                .format(ChatFormatting.GOLD).space()
                .with(Translations.TOOLTIP_TO)
                .format(ChatFormatting.GRAY).space()
                .with(shortDescription)
                .format(ChatFormatting.GRAY)
                .build();
    }

    private String getKeyFromModifier() {
        switch (keyModifier) {
            case NONE:
                return "";
            default:
                return TextUtil.capitaliseFirstLetterFully(keyModifier.name().toLowerCase());
        }
    }
}
