package com.troywubya.mccourse.block;

import com.troywubya.mccourse.MCCourseMod;
import com.troywubya.mccourse.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks
{
    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block",
            () -> new CopperBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)));

    public static void register() { }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(MCCourseMod.COURSE_TAB)));
        return toReturn;
    }

    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore",
            () -> new CopperBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(5f, 3f).sound(SoundType.STONE)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE)));

}


