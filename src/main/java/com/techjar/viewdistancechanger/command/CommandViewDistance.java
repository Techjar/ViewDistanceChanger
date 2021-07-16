package com.techjar.viewdistancechanger.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.text.TextComponentString;

public class CommandViewDistance extends CommandBase {
	@Override
	public String getName() {
		return "viewdistance";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/viewdistance <chunks>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1) {
			throw new WrongUsageException(getUsage(sender));
		}

		int distance = parseInt(args[0], 3, 32);
		server.getPlayerList().setViewDistance(distance);
		if (server instanceof DedicatedServer) {
			((DedicatedServer)server).setProperty("view-distance", distance);
			((DedicatedServer)server).saveProperties();
		}
		sender.sendMessage(new TextComponentString("View distance changed to " + distance));
	}
}
