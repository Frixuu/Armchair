package xyz.lukasz.armchair.common.minecraft.plugin;

public interface MinecraftPlugin<TListener, TCommand> {
    void onEnable();
    void onDisable();

    void registerListener(TListener listener);
    void registerCommand(TCommand command);
}
