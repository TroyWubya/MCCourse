package com.troywubya.mccourse.item;

import com.troywubya.mccourse.MCCourseMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class CopperedApple extends Item
{
    public CopperedApple()
    {
        super(new Properties().group(MCCourseMod.COURSE_TAB)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(1.5f)
                        .effect(() -> new EffectInstance(Effects.GLOWING, 300, 1), .5f)
                        .build()));
    }


}
