package michanide.ticunlimitedtraits.client.book;

import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.SectionData;
import slimeknights.mantle.client.book.repository.BookRepository;
import slimeknights.tconstruct.library.book.sectiontransformer.SectionTransformer;
import michanide.ticunlimitedtraits.integration.ConarmIntegration;

public class BookArmorModifierAppend  extends SectionTransformer{

    private final BookRepository bookData;

    public BookArmorModifierAppend(BookRepository data){
        super("modifiers");
        this.bookData = data;
    }

    @Override
    public void transform(BookData book, SectionData section) {
        ToolAddPage.addPage(bookData, section, "armormodifier", "modifiers/armor.ticunlimitedtraits.coating.json", ConarmIntegration.armorModifierCoating.getLocalizedName());
    }
}
