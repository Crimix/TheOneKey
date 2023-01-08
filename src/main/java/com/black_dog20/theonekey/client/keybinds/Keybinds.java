package com.black_dog20.theonekey.client.keybinds;

import com.black_dog20.theonekey.TheOneKey;
import com.black_dog20.theonekey.api.keybind.IContext;
import com.black_dog20.theonekey.client.DataHolder;
import com.black_dog20.theonekey.client.internal.Context;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import static com.black_dog20.theonekey.common.utils.Translations.KEY_CATEGORY;
import static com.black_dog20.theonekey.common.utils.Translations.KEY_ONE_KEY;

@Mod.EventBusSubscriber(modid = TheOneKey.MOD_ID, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class Keybinds {

    public static final KeyMapping keyOneKey = new KeyMapping(KEY_ONE_KEY.getDescription(), KeyConflictContext.IN_GAME, KeyModifier.NONE, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Y, KEY_CATEGORY.getDescription());

    @SubscribeEvent
    public static void onEvent(TickEvent.ClientTickEvent event) {
        Level level = Minecraft.getInstance().level;
        Player player = Minecraft.getInstance().player;
        if (event.phase != TickEvent.Phase.START || level == null || player == null || Minecraft.getInstance().screen != null) { return; }
        ItemStack heldItemCopy = player.getMainHandItem().copy();
        if (Keybinds.keyOneKey.consumeClick()) {
            com.black_dog20.theonekey.api.keybind.KeyModifier modifier = getKeyModifier();
            if (modifier != null && !heldItemCopy.isEmpty()) {
                IContext context = new Context(modifier, heldItemCopy);
                DataHolder.getKeybindForContext(context).ifPresent(keybind -> keybind.execute(context));
            }

        }
    }

    private static com.black_dog20.theonekey.api.keybind.KeyModifier getKeyModifier() {
        boolean ctrl = Screen.hasControlDown();
        boolean shift = Screen.hasShiftDown();
        boolean alt = Screen.hasAltDown();
        if (!ctrl && !shift && !alt) {
            return com.black_dog20.theonekey.api.keybind.KeyModifier.NONE;
        } else if (ctrl && !shift && !alt) {
            return com.black_dog20.theonekey.api.keybind.KeyModifier.CTRL;
        } else if (!ctrl && shift && !alt) {
            return com.black_dog20.theonekey.api.keybind.KeyModifier.SHIFT;
        } else if (!ctrl && !shift) {
            return com.black_dog20.theonekey.api.keybind.KeyModifier.ALT;
        } else {
            return null;
        }
    }

}
