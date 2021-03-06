package xyz.lukasz.armchair.common.minecraft;

import java.util.UUID;

public interface PlayerAdapter<N> {

    /**
     * Gets a platform-native representation of this player.
     */
    N getNative();

    /**
     * Gets the UUID of this player.
     */
    UUID getUniqueId();

    /**
     * Gets the current username of this player.
     */
    String getName();
}
