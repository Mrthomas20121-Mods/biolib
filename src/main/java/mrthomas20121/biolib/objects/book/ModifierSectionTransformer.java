package mrthomas20121.biolib.objects.book;

import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.PageData;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.book.content.ContentListing;
import slimeknights.tconstruct.library.book.content.ContentModifier;
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer;
import slimeknights.tconstruct.library.modifiers.IModifier;

public class ModifierSectionTransformer extends ContentListingSectionTransformer {

    public ModifierSectionTransformer(String name) {
        super(name);
    }

    @Override
    protected void processPage(BookData book, ContentListing listing, PageData page) {
        if(page.content instanceof ContentModifier) {
            IModifier modifier = TinkerRegistry.getModifier(((ContentModifier) page.content).modifierName);
            if(modifier != null) {
                listing.addEntry(modifier.getLocalizedName(), page);
            }
        }
    }
}