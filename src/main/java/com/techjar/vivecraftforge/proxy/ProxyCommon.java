package com.techjar.vivecraftforge.proxy;

import com.techjar.vivecraftforge.VivecraftForge;
import com.techjar.vivecraftforge.entity.*;
import com.techjar.vivecraftforge.handler.HandlerEntityEvent;
import com.techjar.vivecraftforge.handler.HandlerServerTick;
import com.techjar.vivecraftforge.util.Util;
import com.techjar.vivecraftforge.util.VRPlayerData;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ProxyCommon {
	public void registerRenderers() {
		// Nothing here as the server doesn't render graphics!
	}
	public void registerEntities() {
		EntityRegistry.registerModEntity(EntityVRHead.class, "VRHead", 0, VivecraftForge.instance, 9999, 1, false);
		EntityRegistry.registerModEntity(EntityVRMainArm.class, "VRMainArm", 1, VivecraftForge.instance, 9999, 1, false);
		EntityRegistry.registerModEntity(EntityVROffHandArm.class, "VROffHandArm", 2, VivecraftForge.instance, 9999, 1, false);
	}
	
	public void registerEventHandlers() {
		MinecraftForge.EVENT_BUS.register(new HandlerEntityEvent());
		FMLCommonHandler.instance().bus().register(new HandlerServerTick());
	}
	
	public void registerNetworkChannels() {
	}

	public EntityPlayer getPlayerFromNetHandler(INetHandler netHandler) {
		if (netHandler instanceof NetHandlerPlayServer) {
			return ((NetHandlerPlayServer)netHandler).playerEntity;
		}
		return null;
	}
}
