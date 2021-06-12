package com.troywubya.mccourse.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;

public class CopperBlock extends Block {
    public CopperBlock(Properties properties) {

        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player)
    {
        if(worldIn.isRemote)
        {
            LogManager.getLogger().info("Hello you left clicked on me, Sir");
        }
        super.onBlockClicked(state, worldIn, pos, player);
    }

    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
    {
        if(worldIn.isRemote)
        {
            LogManager.getLogger().info("Hello you jumped on me, Sir. That's not very nice :(");
        }
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
    }
}
