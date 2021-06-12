package com.troywubya.mccourse.events;


import com.troywubya.mccourse.MCCourseMod;
import com.troywubya.mccourse.item.Moditems;
import com.troywubya.mccourse.util.Registration;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;



import java.util.Collection;

public class ModEvents
{
    @SubscribeEvent
    public void onCopperedSheep(AttackEntityEvent event)
    {
        if(event.getPlayer().getHeldItemMainhand().getItem() == Moditems.COPPERED_APPLE.get()) // Player
        {
            if (event.getTarget().isAlive()) // Sheep
            {
                LivingEntity target = (LivingEntity) event.getTarget();
                if(target instanceof SheepEntity)
                {
                    PlayerEntity player = event.getPlayer();

                    // Deletes the item
                    player.getHeldItemMainhand().shrink(1);

                    target.addPotionEffect(new EffectInstance(Effects.GLOWING, 600));

                    if(!player.world.isRemote())
                    {
                        String msg = TextFormatting.YELLOW + " sheep is glowing now!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onCopperedSheepDrops(LivingDropsEvent event)
    {
        LivingEntity entity = event.getEntityLiving();

        if(entity instanceof SheepEntity)
        {
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();

            LogManager.getLogger().debug(entity.getActivePotionEffects());

            if (entity.isPotionActive(Effects.GLOWING))
            {
                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(Moditems.COPPER_INGOT.get())));
            }
        }
    }
}

