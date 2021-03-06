package xyz.lukasz.armchair.spigot.minecraft;

import com.google.common.base.Preconditions;
import org.bukkit.entity.Player;
import xyz.lukasz.armchair.common.minecraft.PlayerAdapter;

import java.util.UUID;

public class SpigotPlayerAdapter implements PlayerAdapter<Player> {

    protected final Player nativePlayer;

    protected SpigotPlayerAdapter(Player nativePlayer) {
        Preconditions.checkNotNull(nativePlayer);
        this.nativePlayer = nativePlayer;
    }

    @Override
    public Player getNative() {
        return nativePlayer;
    }

    @Override
    public UUID getUniqueId() {
        return nativePlayer.getUniqueId();
    }

    @Override
    public String getName() {
        return nativePlayer.getName();
    }

    public static SpigotPlayerAdapter wrap(Player nativePlayer) {
        return new SpigotPlayerAdapter(nativePlayer);
    }
}
