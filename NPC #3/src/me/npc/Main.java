package me.npc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.npc.nms.NPC;
import me.npc.nms.NPCLibrary;
import me.npc.nms.NPCProfile;

public class Main extends JavaPlugin implements CommandExecutor {
	
	private static Main instance;
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		getCommand("setNPC").setExecutor(this);
	}
	
	@Override
	public void onDisable() {
		for (NPC npc : NPCLibrary.listNPCs()) {
			npc.despawn();
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		if (command.getName().equals("setNPC")) {
			Player player = (Player)sender;
			NPC npc = new NPC(UUID.randomUUID(), "§7[NPC] 1345");
			new Thread() {
				@Override
				public void run() {
					NPCProfile profile = NPCProfile.loadProfile("§7[NPC] 1345", "KingoZ_");
					Bukkit.getScheduler().runTask(Main.getInstance(), new Runnable() {
						
						@Override
						public void run() {
							npc.spawn(player.getLocation(), profile);
							
						}
					});
				};
			}.start();
			player.sendMessage("§aNPC spawnado com sucesso!");
		}
		return false;
	}

}
