package fr.dibou.moddibou.datagen;

import fr.dibou.moddibou.ModDibou;
import fr.dibou.moddibou.block.ModBlocks;
import fr.dibou.moddibou.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModDibou.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.RUBY_DETECTOR);
        simpleItem(ModItems.STRAWBERRY);

        simplerBlockItem(ModBlocks.RUBY_STAIR);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModDibou.MODID, "item/" + item.getId().getPath()));
    }

    public void simplerBlockItem(RegistryObject<Block> block){
        this.withExistingParent(ModDibou.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey((block.get())).getPath()));
    }
}
