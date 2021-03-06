package xyz.lukasz.armchair.spigot.minecraft.plugin;

import org.apache.commons.lang.Validate;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.lukasz.armchair.common.minecraft.plugin.MinecraftPlugin;

public abstract class SpigotPlugin extends JavaPlugin implements MinecraftPlugin<Listener, Command> {

    @Override
    public void registerListener(Listener listener) {
        this.getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void registerCommand(Command command) {
        final var pluginCommand = this.getCommand(command.getName());
        Validate.notNull(pluginCommand);
        pluginCommand.setExecutor(command);
        pluginCommand.setTabCompleter(command);
    }
}
