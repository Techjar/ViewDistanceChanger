package com.techjar.viewdistancechanger;

import com.techjar.viewdistancechanger.command.CommandViewDistance;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = "viewdistancechanger", name = "View Distance Changer", version = "@VERSION@", acceptedMinecraftVersions = "1.12.2", acceptableRemoteVersions = "*")
public class ViewDistanceChanger {
	@Mod.Instance("viewdistancechanger")
	public static ViewDistanceChanger instance;

	@Mod.EventHandler
	public void onServerStart(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandViewDistance());
	}
}
