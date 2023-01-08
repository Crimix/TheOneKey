package com.black_dog20.theonekey.client.events;

import com.black_dog20.theonekey.TheOneKey;
import com.black_dog20.theonekey.api.keybind.KeyModifier;
import com.black_dog20.theonekey.client.DataHolder;
import com.black_dog20.theonekey.client.internal.Context;
import com.black_dog20.theonekey.client.internal.Keybind;
import com.black_dog20.theonekey.common.utils.Translations;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = TheOneKey.MOD_ID, value = Dist.CLIENT)
public class TooltipHandler {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack().copy();
        if (!itemStack.isEmpty()) {
            Optional<Keybind> none = DataHolder.getKeybindForContext(new Context(KeyModifier.NONE, itemStack));
            Optional<Keybind> ctrl = DataHolder.getKeybindForContext(new Context(KeyModifier.CTRL, itemStack));
            Optional<Keybind> alt = DataHolder.getKeybindForContext(new Context(KeyModifier.ALT, itemStack));
            Optional<Keybind> shift = DataHolder.getKeybindForContext(new Context(KeyModifier.SHIFT, itemStack));

            if (none.isPresent() || ctrl.isPresent() || alt.isPresent() || shift.isPresent()) {
                if (!Screen.hasAltDown()) {
                    event.getToolTip().add(Translations.TOOLTIP_SHOW.get());
                } else {
                    event.getToolTip().clear();
                    event.getToolTip().add(Translations.TOOLTIP_PROVIDED.get());
                    none.ifPresent(key -> event.getToolTip().add(key.getTooltip()));
                    ctrl.ifPresent(key -> event.getToolTip().add(key.getTooltip()));
                    alt.ifPresent(key -> event.getToolTip().add(key.getTooltip()));
                    shift.ifPresent(key -> event.getToolTip().add(key.getTooltip()));
                }
            }

        }

    }
}
