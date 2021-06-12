package com.troywubya.mccourse.item;

import com.troywubya.mccourse.MCCourseMod;
import com.troywubya.mccourse.util.Registration;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class Moditems
{
    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
                    () -> new CopperItem(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_WIRE =
            Registration.ITEMS.register("copper_wire",
                    () -> new CopperWire(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPERED_APPLE =
            Registration.ITEMS.register("coppered_apple",
                    () -> new CopperedApple());

    public static final RegistryObject<Item> COPPER_SHOVEL =
            Registration.ITEMS.register("copper_shovel",
                    () -> new ShovelItem(ModItemTier.COPPER, 0f, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.SHOVEL, 2)
                                    .group(MCCourseMod.COURSE_TAB)));


    public static final RegistryObject<Item> COPPER_SWORD =
            Registration.ITEMS.register("copper_sword",
                    () -> new SwordItem(ModItemTier.COPPER, 4, 0.5f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .group(MCCourseMod.COURSE_TAB)));


    public static final RegistryObject<Item> COPPER_PICKAXE =
            Registration.ITEMS.register("copper_pickaxe",
                    () -> new PickaxeItem(ModItemTier.COPPER, 2, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 1)
                                    .group(MCCourseMod.COURSE_TAB)));


    public static final RegistryObject<Item> COPPER_HOE =
            Registration.ITEMS.register("copper_hoe",
                    () -> new HoeItem(ModItemTier.COPPER, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.HOE, 1)
                                    .group(MCCourseMod.COURSE_TAB)));


    public static final RegistryObject<Item> COPPER_AXE =
            Registration.ITEMS.register("copper_axe",
                    () -> new AxeItem(ModItemTier.COPPER, 3f, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.AXE, 1)
                                    .group(MCCourseMod.COURSE_TAB)));

    public static void register() { }

    public enum ModItemTier implements IItemTier
    {
        COPPER(2, 150, 2.5f, 0f, 15,
                Ingredient.fromStacks(new ItemStack(Moditems.COPPER_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency,
                    float attackDamage, int enchantability, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses()
        {
            return maxUses;
        }

        @Override
        public float getEfficiency()
        {
            return efficiency;
        }

        @Override
        public float getAttackDamage()
        {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel()
        {
            return harvestLevel;
        }

        @Override
        public int getEnchantability()
        {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return repairMaterial;
        }
    }

}
