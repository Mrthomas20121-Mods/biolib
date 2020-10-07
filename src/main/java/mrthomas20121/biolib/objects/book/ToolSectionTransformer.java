package mrthomas20121.biolib.objects.book;

import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.PageData;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.book.content.ContentListing;
import slimeknights.tconstruct.library.book.content.ContentTool;
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer;
import slimeknights.tconstruct.library.tools.ToolCore;

import java.util.Optional;

public class ToolSectionTransformer extends ContentListingSectionTransformer {

    public ToolSectionTransformer(String name) {
        super(name);
    }

    @Override
    protected void processPage(BookData book, ContentListing listing, PageData page) {
        // only add tool pages if the tool exists
        if(page.content instanceof ContentTool) {
            String toolName = ((ContentTool) page.content).toolName;
            Optional<ToolCore> tool = TinkerRegistry.getTools().stream()
                    .filter(toolCore -> toolName.equals(toolCore.getIdentifier()))
                    .findFirst();

            tool.ifPresent(toolCore -> listing.addEntry(toolCore.getLocalizedName(), page));
        }
        else {
            super.processPage(book, listing, page);
        }
    }
}