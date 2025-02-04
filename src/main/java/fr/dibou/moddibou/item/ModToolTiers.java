package fr.dibou.moddibou.item;

import fr.dibou.moddibou.block.ModBlocks;
import fr.dibou.moddibou.util.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

import java.util.function.Supplier;

public class ModToolTiers {
    public static final Tier RUBY = new ForgeTier(2000, 9f, 5f, 22, ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get()), BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
}
