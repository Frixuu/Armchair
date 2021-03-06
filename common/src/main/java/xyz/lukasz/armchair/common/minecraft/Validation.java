package xyz.lukasz.armchair.common.minecraft;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

@UtilityClass
public final class Validation {

    private static final Pattern usernamePattern
        = Pattern.compile("^[a-zA-Z0-9_]{3,16}$");

    /**
     * Checks if the provided input is a valid Minecraft username,
     * according to Mojang spec.
     * @param username The player's username.
     * @return The check result.
     * @see <a href="https://help.minecraft.net/hc/en-us/articles/360034636712">Minecraft KB</a>
     */
    public static boolean isValidUsername(@NotNull String username) {
        return usernamePattern.matcher(username).matches();
    }
}
