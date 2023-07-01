package michanide.ticunlimitedtraits.integration;

import slimeknights.mantle.client.book.repository.FileRepository;
import c4.conarm.lib.book.ArmoryBook;
import c4.conarm.lib.utils.RecipeMatchHolder;
import michanide.ticunlimitedtraits.TiCUnlimitedTraits;
import michanide.ticunlimitedtraits.client.book.BookArmorModifierAppend;
import michanide.ticunlimitedtraits.modifier.ArmorModifierCoating;

public class ConarmIntegration {

    public static ArmorModifierCoating armorModifierCoating;

    public static void armorBookAppend(){
        ArmoryBook.INSTANCE.addTransformer(new BookArmorModifierAppend(new FileRepository("conarm:book")));
    }

    public static void initArmorModifierItems(){
        RecipeMatchHolder.addItem(armorModifierCoating, TiCUnlimitedTraits.coatingMaterial);
    }
}
