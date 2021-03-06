package xyz.lukasz.armchair.spigot.minecraft;

import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static org.bukkit.Material.ACACIA_LOG;
import static org.bukkit.Material.BIRCH_LOG;
import static org.bukkit.Material.COARSE_DIRT;
import static org.bukkit.Material.DARK_OAK_LOG;
import static org.bukkit.Material.DIRT;
import static org.bukkit.Material.GRASS_BLOCK;
import static org.bukkit.Material.JUNGLE_LOG;
import static org.bukkit.Material.OAK_LOG;
import static org.bukkit.Material.PODZOL;
import static org.bukkit.Material.SPRUCE_LOG;

@UtilityClass
public final class Materials {

    private static final Set<Material> MATERIALS_DIRT
        = Set.of(DIRT, GRASS_BLOCK, PODZOL, COARSE_DIRT);

    private static final Set<Material> MATERIALS_LOG
        = Set.of(OAK_LOG, BIRCH_LOG, SPRUCE_LOG, JUNGLE_LOG, ACACIA_LOG, DARK_OAK_LOG);

    /**
     * Checks whether this block's material is some kind of dirt.
     * @param block The block to check.
     * @return True if the block is a kind of dirt, false otherwise.
     */
    public static boolean isDirt(@NotNull Block block) {
        return isDirt(block.getType());
    }

    /**
     * Checks whether a material is some kind of dirt.
     * @param material The material to check.
     * @return True if the material is a kind of dirt, false otherwise.
     */
    public static boolean isDirt(@NotNull Material material) {
        return MATERIALS_DIRT.contains(material);
    }

    /**
     * Checks whether this block's material is some kind of log.
     * @param block The block to check.
     * @return True if the block is a kind of log, false otherwise.
     */
    public static boolean isLog(@NotNull Block block) {
        return isLog(block.getType());
    }

    /**
     * Checks whether a material is some kind of log.
     * @param material The material to check.
     * @return True if the material is a kind of log, false otherwise.
     */
    public static boolean isLog(@NotNull Material material) {
        return MATERIALS_LOG.contains(material);
    }
}
