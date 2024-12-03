package net.prizowo.noarrowsinyou;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.prizowo.noarrowsinyou.config.NAIYConfig;
import net.prizowo.noarrowsinyou.config.NAIYConfigScreen;

@Mod(NAIY.MOD_ID)
public class NAIY {
    public static final String MOD_ID = "noarrowsinyou";
    private static NAIYConfig config;

    public NAIY() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::clientSetup);

        config = NAIYConfig.get();
        NAIYConfig.register();
        NAIYConfigScreen.register();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }

    public static NAIYConfig getConfig() {
        return config;
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isLocalPlayer(Entity entity) {
        if(!NAIY.getConfig().onlyLocal())
            return true;
        return Minecraft.getInstance().player != null &&
                Minecraft.getInstance().player.getUUID().equals(entity.getUUID());
    }
}
