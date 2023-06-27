package maxe.projektwoche;

import maxe.projektwoche.Commands.commandGUI;
import maxe.projektwoche.Events.ClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        kitpvp1.maxe.Main.setPlugin(this);
        kitpvp1.maxe.Main.setConfig(getConfig());
        kitpvp1.maxe.Main.setup();

        getServer().getPluginManager().registerEvents(new ClickListener(), this);

        getCommand("start").setExecutor(new commandGUI());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
