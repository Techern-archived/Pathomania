package com.techern.minecraft.pathomania.proxy;

import com.techern.minecraft.pathomania.PathomaniaMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * An implementation of {@link CommonProxy} for use on the client {@link net.minecraftforge.fml.relauncher.Side}
 *
 * @since 0.0.1
 */
public class ClientProxy extends CommonProxy {

    /**
     * Registers a {@link Block}'s inventory model
     *
     * @param block The {@link Block} being registered
     * @param metadata The {@link Integer} used to store metadata
     * @param modelName A {@link String} depicting the name of the model
     *
     * @since 0.0.1
     */
    public void registerBlockInventoryModel(Block block, int metadata, String modelName) {
        PathomaniaMod.LOGGER.trace("Got a request to register inventory model for " + block.getLocalizedName() + ", doing so");

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block).setHasSubtypes(true), metadata, new ModelResourceLocation("pathomania:" + modelName, "inventory"));

    }

}