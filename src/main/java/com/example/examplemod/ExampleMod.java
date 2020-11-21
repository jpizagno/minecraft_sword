package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


/**
 * https://codakid.com/guide-to-minecraft-modding-with-java/
 */

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "sword";
    public static final String NAME = "Tristan's Custom sword";
    public static final String VERSION = "1.0";

    private static Logger logger;


    public static ToolMaterial myToolMaterial;
    public static Item mySword;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        // The harvest level indicates which minerals it can get resources from.
        // If we applied this material to a pickaxe, this is where we would define if it can get diamonds from Diamond Ore.
        // Putting this at 4 lets it mine whatever we want it to.
        int harvestLevel = 4; //

        // maxUses is how many times we can use it before it breaks,
        int maxUses = 10000;

        //  the efficiency is applied for harvesting tools for how quickly it will mine or harvest a block.
        float efficiency = 20.0F;

        // The damage is how much damage it will do when you hit an entity with it.
        float damage = 100.0F;

        // The enchantability is related to how easy it is to enchant.
        int enchantability = 30;

        myToolMaterial = EnumHelper.addToolMaterial("sword name"
                , harvestLevel
                , maxUses
                , efficiency
                , damage
                , enchantability);

        mySword = new CustomSword();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());


    }
}
