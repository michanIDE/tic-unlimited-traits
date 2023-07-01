package michanide.ticunlimitedtraits.client.book;

import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.SectionData;
import slimeknights.mantle.client.book.repository.BookRepository;
import slimeknights.tconstruct.library.book.sectiontransformer.SectionTransformer;
import michanide.ticunlimitedtraits.TiCUnlimitedTraits;

public class BookModifierAppend extends SectionTransformer{

    private final BookRepository bookData;

    public BookModifierAppend(BookRepository data){
        super("modifiers");
        this.bookData = data;
    }

    @Override
    public void transform(BookData book, SectionData section) {
        ToolAddPage.addPage(bookData, section, "modifier", "modifiers/ticunlimitedtraits.coating.json", TiCUnlimitedTraits.modifierCoating.getLocalizedName());
    }
}
