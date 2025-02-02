package fr.dibou.moddibou.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class WoodMagicStick extends Item {
    public WoodMagicStick(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide){
            Level level = pContext.getLevel();
            Vec3 clikedPos = pContext.getClickLocation();

            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            lightningBolt.moveTo(clikedPos);
            lightningBolt.setDamage(100f);
            level.addFreshEntity(lightningBolt);
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), EquipmentSlot.MAINHAND);
        return InteractionResult.SUCCESS;
    }
}
