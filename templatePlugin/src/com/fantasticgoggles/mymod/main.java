package com.fantasticgoggles.mymod;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

	@Override
	public void onEnable() {
		// TODO Insert logic to be performed when the plugin is enabled

		// Commands enabled with following method must have entries in plugin.yml
		getCommand("example").setExecutor(new command(this));
		getServer().getPluginManager().registerEvents(new listener(), this);
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}
}
