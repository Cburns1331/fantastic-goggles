package com.fantasticgoggles.mymod;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FrogMode implements CommandExecutor {
    FoggyFrog plugin;
    boolean isFrog = false;

    public FrogMode(FoggyFrog plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String cmdName = cmd.getName().toLowerCase();
        PotionEffect frogJump = new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 4, false, true, false);
        PotionEffect frogFog = new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1, false, true, false);
        PotionEffect frogFall = new PotionEffect(PotionEffectType.SLOW_FALLING, Integer.MAX_VALUE, (int) .5, false, false, false);

        if (cmdName.equals("frogmode") && isFrog == false && args.length == 0 && sender instanceof Player) {
        	sender.sendMessage("Successfully used frogmode command!");
        	isFrog = true;
        	((Player) sender).addPotionEffect(frogJump, true);
        	((Player) sender).addPotionEffect(frogFog, true);
        	//((Player) sender).addPotionEffect(frogFall, true);
        	((Player) sender).setFallDistance(-1000000);
        	return true;
        }
        else if(cmdName.equals("frogmode") && isFrog == true && args.length == 0 && sender instanceof Player) {
        	sender.sendMessage("Disabling frogmode...");
        	isFrog = false;
        	((Player) sender).removePotionEffect(PotionEffectType.JUMP);
        	((Player) sender).removePotionEffect(PotionEffectType.BLINDNESS);
        	//((Player) sender).removePotionEffect(PotionEffectType.SLOW_FALLING);
        	((Player) sender).setFallDistance((float) 3.7);
        	return true;
        }
        else {
        	if(!(sender instanceof Player)) {
        		sender.sendMessage("Only players can use this command!");
        		return false;
        	}
        	else {
        		sender.sendMessage("Error with command, please try again /frogmode");
        		return false;
        	}
        }
    }
}