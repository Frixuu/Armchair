package xyz.lukasz.armchair.bungee.minecraft.plugin;

import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.lukasz.armchair.common.minecraft.plugin.MinecraftPlugin;

public abstract class BungeePlugin extends Plugin implements MinecraftPlugin<Listener, Command> {

    @Override
    public void registerListener(Listener listener) {
        this.getProxy().getPluginManager().registerListener(this, listener);
    }

    @Override
    public void registerCommand(Command command) {
        this.getProxy().getPluginManager().registerCommand(this, command);
    }
}
