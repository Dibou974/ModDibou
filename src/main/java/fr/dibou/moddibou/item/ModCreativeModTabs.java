package fr.dibou.moddibou.item;

import fr.dibou.moddibou.ModDibou;
import fr.dibou.moddibou.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModDibou.MODID);

    public static final RegistryObject<CreativeModeTab> MODDIBOU_TAB = CREATIVE_MODE_TABS.register("moddibou_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
            .title(Component.translatable("creativetab.moddibou_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.RUBY.get());
                pOutput.accept(ModItems.STRAWBERRY.get());

                pOutput.accept(ModItems.RUBY_DETECTOR.get());
                pOutput.accept(ModItems.WOOD_MAGIC_STICK.get());

                pOutput.accept(ModItems.RUBY_SWORD.get());
                pOutput.accept(ModItems.RUBY_PICKAXE.get());

                pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                pOutput.accept(ModBlocks.RUBY_ORE.get());
                pOutput.accept(ModBlocks.RUBY_MUSIC_BLOCK.get());
                pOutput.accept(ModBlocks.RUBY_STAIR.get());
            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
