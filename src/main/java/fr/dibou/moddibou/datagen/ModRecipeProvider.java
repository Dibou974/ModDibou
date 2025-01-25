package fr.dibou.moddibou.datagen;

import fr.dibou.moddibou.block.ModBlocks;
import fr.dibou.moddibou.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get())
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(recipeOutput);
    }


}
