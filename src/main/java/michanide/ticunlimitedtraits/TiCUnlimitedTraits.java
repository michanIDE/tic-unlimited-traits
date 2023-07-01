package michanide.ticunlimitedtraits;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import michanide.ticunlimitedtraits.modifier.ArmorModifierCoating;
import michanide.ticunlimitedtraits.modifier.ModifierCoating;
import michanide.ticunlimitedtraits.items.ItemCoatingMaterial;
import michanide.ticunlimitedtraits.integration.ConarmIntegration;


@Mod.EventBusSubscriber
@Mod(modid = TiCUnlimitedTraitsMeta.MODID, 
    version = TiCUnlimitedTraitsMeta.VERSION,
    name = TiCUnlimitedTraitsMeta.NAME, 
    dependencies = TiCUnlimitedTraitsMeta.DEPENDENCIES,
    acceptedMinecraftVersions = TiCUnlimitedTraitsMeta.ACCEPTED_MINECRAFT_VER
)
public class TiCUnlimitedTraits
{

    @SidedProxy(clientSide = "michanide.ticunlimitedtraits.ClientProxy", serverSide = "michanide.ticunlimitedtraits.CommonProxy")
    public static CommonProxy proxy;

    public static ModifierCoating modifierCoating = new ModifierCoating();

    public static Item coatingMaterial = new ItemCoatingMaterial();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		initItems(event.getRegistry());
        initModifierItems();
	}

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(coatingMaterial, 0, new ModelResourceLocation(new ResourceLocation("ticunlimitedtraits", "coating_material"), "inventory"));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.onPostInit(event);
        modifierCoating.addItem(new ItemStack(coatingMaterial), 1, 1);
        if(Loader.isModLoaded("conarm")){
            ConarmIntegration.armorModifierCoating = new ArmorModifierCoating();
            ConarmIntegration.initArmorModifierItems();
        }
    }

    protected static void initModifierItems(){
        
    }

    public static void initItems(IForgeRegistry<Item> registry){
        coatingMaterial.setTranslationKey("coating_material").setRegistryName(new ResourceLocation(TiCUnlimitedTraitsMeta.MODID, "coating_material")).setCreativeTab(TinkerRegistry.tabGeneral);
        registry.register(coatingMaterial);
    }
}
