package com.techern.minecraft.pathomania.proxy;

import com.techern.minecraft.pathomania.PathomaniaMod;
import net.minecraft.block.Block;

/**
 * An implementation of {@link CommonProxy} for use on the server {@link net.minecraftforge.fml.relauncher.Side}
 *
 * @since 0.0.1
 */
public class ServerProxy extends CommonProxy {

    /**
     * Registers a {@link Block}'s inventory model
     *
     * @param block The {@link Block} being registered
     * @param modelLocation A {@link String} depicting the location of the model
     * @since 0.0.1
     */
    public void registerBlockInventoryModel(Block block, String modelLocation) {
        PathomaniaMod.LOGGER.trace("Got a request to register inventory model for " + block.getLocalizedName() + ", ignoring");
    }

}