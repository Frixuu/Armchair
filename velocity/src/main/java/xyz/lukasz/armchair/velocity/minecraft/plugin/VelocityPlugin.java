package xyz.lukasz.armchair.velocity.minecraft.plugin;

import com.velocitypowered.api.command.BrigadierCommand;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.EventManager;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import xyz.lukasz.armchair.common.minecraft.plugin.MinecraftPlugin;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class VelocityPlugin implements MinecraftPlugin<Object, BrigadierCommand> {

    protected final EventManager eventManager;
    protected final CommandManager commandManager;

    @Subscribe
    protected void onProxyInitialize(ProxyInitializeEvent event) {
        onEnable();
    }

    @Override
    public void onEnable() {

    }

    @Subscribe
    protected void onProxyShutdown(ProxyShutdownEvent event) {
        onDisable();
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void registerListener(Object listener) {
        eventManager.register(this, listener);
    }

    @Override
    public void registerCommand(BrigadierCommand command) {
        commandManager.register(command);
    }
}
