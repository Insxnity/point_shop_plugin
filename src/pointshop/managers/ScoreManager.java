package pointshop.managers;

import org.bukkit.entity.Player;
import pointshop.Main;

public class ScoreManager {

	private static Main plugin;

	public ScoreManager(Main plugin) {
		this.plugin = plugin; // Accessing the instance of the Main class
	}

	public static void addScore(Player p, int i) {
		int score = plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score");
		if (!plugin.getConfig().contains("Players." + p.getName() + p.getUniqueId())) {
			plugin.getConfig().set("Players." + p.getName() + p.getUniqueId() + ".Score", i);
			plugin.saveConfig();
		} else {
			plugin.getConfig().set("Players." + p.getName() + p.getUniqueId() + ".Score", plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score") + 1);
		}
	}

	public static int getScore(Player p) {
		return plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score");
	}

	public static void removeScore(Player p, int i) {
		int score = plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score");
		if (!plugin.getConfig().contains("Players." + p.getName() + p.getUniqueId())) {
			plugin.getConfig().set("Players." + p.getName() + p.getUniqueId() + ".Score", 0);
			plugin.saveConfig();
		} else {
			plugin.getConfig().set("Players." + p.getName() + p.getUniqueId() + ".Score", plugin.getConfig().getInt("Players." + p.getUniqueId() + ".Score") - i);
		}
	}


}
