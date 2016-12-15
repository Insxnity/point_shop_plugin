package pointshop.managers;

import org.bukkit.entity.Player;
import pointshop.Main;

public class ScoreManager {

	private static Main plugin;

	public ScoreManager(Main plugin) {
		this.plugin = plugin; // Accessing the instance of the Main class
	}

	public static void addScore(Player p, int i) {
		String playerConfig = "Players." + p.getName() + p.getUniqueId();
		if (!plugin.getConfig().contains(playerConfig)) {
			plugin.getConfig().set(playerConfig + ".Score", i);
		} else {
			plugin.getConfig().set(playerConfig + ".Score", getScore(p) + i);
		}
		plugin.saveConfig();
	}

	public static int getScore(Player p) {
		return plugin.getConfig().getInt("Players." + p.getName() + p.getUniqueId() + ".Score");
	}

	public static void removeScore(Player p, int i) {
		String playerConfig = "Players." + p.getName() + p.getUniqueId();
		if (!plugin.getConfig().contains(playerConfig)) {
			plugin.getConfig().set(playerConfig + ".Score", 0);
		} else {
			int s = getScore(p) - i;
			plugin.getConfig().set(playerConfig + ".Score", s < 0 ? 0 : s); //Prevents value from going below 0
		}
		plugin.saveConfig();
	}


}
