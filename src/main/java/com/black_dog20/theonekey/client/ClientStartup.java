package com.black_dog20.theonekey.client;

import com.black_dog20.theonekey.TheOneKey;
import com.black_dog20.theonekey.api.plugin.IModPlugin;
import com.black_dog20.theonekey.client.keybinds.Keybinds;
import com.black_dog20.theonekey.client.utils.PluginFinder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = TheOneKey.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientStartup {

    @SubscribeEvent
    public static void registerKeyBinding(RegisterKeyMappingsEvent event) {
        event.register(Keybinds.keyOneKey);
    }

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        List<IModPlugin> modPlugins = PluginFinder.getModPlugins();
    }
}