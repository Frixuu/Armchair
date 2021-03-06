package xyz.lukasz.armchair.spigot.minecraft.plugin;

import lombok.Getter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A Spigot command abstraction in the style of BungeeCord.
 */
public abstract class Command implements CommandExecutor, TabCompleter {

    @Getter
    private final String name;

    public Command(String name) {
        this.name = name;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             org.bukkit.command.@NotNull Command command,
                             @NotNull String label,
                             String[] args) {
        execute(sender, args);
        return true;
    }

    public abstract void execute(@NotNull CommandSender sender, String[] args);

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender,
                                      org.bukkit.command.@NotNull Command command,
                                      @NotNull String alias, String[] args) {
        return onTabComplete(sender, args);
    }

    public List<String> onTabComplete(@NotNull CommandSender sender, String[] args) {
        return null;
    }
}
