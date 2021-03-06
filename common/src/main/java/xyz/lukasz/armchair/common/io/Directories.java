package xyz.lukasz.armchair.common.io;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

@UtilityClass
public final class Directories {

    /**
     * Tries to create a folder, if it currently does not exist.
     * @param directory The directory to check.
     * @throws SecurityException if a security manager exists and denies the access.
     * @throws IOException if a directory does not exist, but somehow could not be created.
     */
    public static void ensureDirectoryExists(@NotNull File directory) throws IOException {
        if (!directory.exists() && !directory.mkdir()) {
            throw new IOException(String.format(
                "The directory %s is absent and could not be created.",
                directory.getPath()));
        }
    }
}
