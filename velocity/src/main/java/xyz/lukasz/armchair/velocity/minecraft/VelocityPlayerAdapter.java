package xyz.lukasz.armchair.velocity.minecraft;

import com.google.common.base.Preconditions;
import com.velocitypowered.api.proxy.Player;
import xyz.lukasz.armchair.common.minecraft.PlayerAdapter;

import java.util.UUID;

public class VelocityPlayerAdapter implements PlayerAdapter<Player> {

    protected final Player nativePlayer;

    protected VelocityPlayerAdapter(Player nativePlayer) {
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
        return nativePlayer.getUsername();
    }

    public static VelocityPlayerAdapter wrap(Player nativePlayer) {
        return new VelocityPlayerAdapter(nativePlayer);
    }
}
