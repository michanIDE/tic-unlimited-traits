package michanide.ticunlimitedtraits;

import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.Loader;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.tconstruct.library.book.TinkerBook;
import michanide.ticunlimitedtraits.client.book.BookModifierAppend;
import michanide.ticunlimitedtraits.integration.ConarmIntegration;

public class ClientProxy extends CommonProxy {

    @Override
    public void onPostInit(FMLPostInitializationEvent event){
        super.onPostInit(event);
        TinkerBook.INSTANCE.addTransformer(new BookModifierAppend(new FileRepository("tconstruct:book")));
        if(Loader.isModLoaded("conarm")){
            ConarmIntegration.armorBookAppend();
        }
    }
}
