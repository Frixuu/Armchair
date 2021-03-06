package xyz.lukasz.armchair.bungee.minecraft;

import com.google.common.base.Preconditions;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import xyz.lukasz.armchair.common.minecraft.PlayerAdapter;

import java.util.UUID;

public class BungeePlayerAdapter implements PlayerAdapter<ProxiedPlayer> {

    protected final ProxiedPlayer nativePlayer;

    protected BungeePlayerAdapter(ProxiedPlayer nativePlayer) {
        Preconditions.checkNotNull(nativePlayer);
        this.nativePlayer = nativePlayer;
    }

    @Override
    public ProxiedPlayer getNative() {
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

    public static BungeePlayerAdapter wrap(ProxiedPlayer nativePlayer) {
        return new BungeePlayerAdapter(nativePlayer);
    }
}
