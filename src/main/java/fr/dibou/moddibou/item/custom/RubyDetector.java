package fr.dibou.moddibou.item.custom;

import fr.dibou.moddibou.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

public class RubyDetector extends Item {

    public RubyDetector(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext){
        if(!pContext.getLevel().isClientSide){
            Player player = pContext.getPlayer();
            BlockPos blockClickedPos = pContext.getClickedPos();
            boolean foundBlock = false;

            for(int i = 0; i <= blockClickedPos.getY() + 64; i++){
                BlockState state = pContext.getLevel().getBlockState(blockClickedPos.below(i));

                if(isValuableBlock(state)){
                    foundBlock = true;
                    SendMessageToPlayer(player, blockClickedPos.below(i));
                    break;
                }
            }

            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("Pas de minerai de ruby trouvé !"));
            }
        }

        return InteractionResult.SUCCESS;
    }


    private void SendMessageToPlayer(Player player, BlockPos blockPos) {
        player.sendSystemMessage(Component.literal("Un bloc de ruby a été trouvé au coordonnées : " + blockPos.getX() + "X, " + blockPos.getY() + "Y, " + blockPos.getZ() + "Z"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModBlocks.RUBY_ORE.get());
    }


}
