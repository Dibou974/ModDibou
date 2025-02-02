package fr.dibou.moddibou.item;

import fr.dibou.moddibou.ModDibou;
import fr.dibou.moddibou.item.custom.RubyDetector;
import fr.dibou.moddibou.item.custom.WoodMagicStick;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModDibou.MODID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item>  RUBY_DETECTOR = ITEMS.register("ruby_detector", () -> new RubyDetector(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> WOOD_MAGIC_STICK = ITEMS.register("wood_magic_stick", () -> new WoodMagicStick(new Item.Properties().durability(500).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
