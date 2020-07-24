package com.fantasticgoggles.mymod;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FrogMode implements CommandExecutor {
    FoggyFrog plugin;

    public FrogMode(FoggyFrog plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String cmdName = cmd.getName().toLowerCase();

        if (cmdName.equals("frogmode")) {
        	if (sender instanceof Player) {
        		sender.sendMessage("Successfully used frogmode command!");
        		PotionEffect frogJump = new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 4, false, true, false);
        		((Player) sender).addPotionEffect(frogJump, true);
        		return true;
        	}
        	else {
        		sender.sendMessage("Only players can use this command!");
        		return false;
        	}
        }
        else {
        	return false;
        }
    }
}