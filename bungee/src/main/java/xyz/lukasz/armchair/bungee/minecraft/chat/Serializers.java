package xyz.lukasz.armchair.bungee.minecraft.chat;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.jetbrains.annotations.NotNull;

import static java.util.concurrent.TimeUnit.MINUTES;

@UtilityClass
public final class Serializers {

    private static final LoadingCache<String, BaseComponent[]> componentCache = CacheBuilder
        .newBuilder()
        .expireAfterAccess(30L, MINUTES)
        .maximumSize(1000)
        .build(new CacheLoader<>() {
            @Override
            public BaseComponent[] load(String message) {
                return TextComponent.fromLegacyText(
                    ChatColor.translateAlternateColorCodes('&', message));
            }
        });

    /**
     * Converts a legacy message with color codes using ampersands
     * to a format understandable by BungeeCord.
     * @param message A message in the legacy format.
     * @return Bungee-native chat components, which might be loaded from cache.
     */
    public static @NotNull BaseComponent[] toChat(@NotNull String message) {
        return componentCache.getUnchecked(message);
    }
}
