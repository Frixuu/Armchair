package xyz.lukasz.armchair.common.minecraft;

import com.google.common.base.Charsets;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@UtilityClass
public final class Uuids {

    /**
     * Generates an offline mode UUID from a player username.
     * @param username A player's Minecraft username.
     * @return A new UUID object.
     */
    @Contract("_ -> new")
    public static @NotNull UUID getOfflineFromUsername(@NotNull String username) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + username).getBytes(Charsets.UTF_8));
    }
}
