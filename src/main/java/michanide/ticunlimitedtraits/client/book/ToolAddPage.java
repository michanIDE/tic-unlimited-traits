package michanide.ticunlimitedtraits.client.book;

import slimeknights.mantle.client.book.data.SectionData;
import slimeknights.mantle.client.book.data.PageData;
import slimeknights.mantle.client.book.repository.BookRepository;
import slimeknights.tconstruct.library.book.content.ContentListing;

public class ToolAddPage {
    public static void addPage(BookRepository source, SectionData section, String type, String dataLoc, String locName){
        PageData page = new PageData();
        ContentListing contentList = (ContentListing)section.pages.get(0).content;

        page.source = source;
        page.parent = section;
        page.type = type;
        page.data = dataLoc;
        section.pages.add(page);
        page.load();
        contentList.addEntry(locName, page);
    }
}
