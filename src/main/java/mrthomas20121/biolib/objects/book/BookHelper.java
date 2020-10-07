package mrthomas20121.biolib.objects.book;

import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.tconstruct.library.book.TinkerBook;

public class BookHelper {

    private final String mod;
    private FileRepository repository;

    public BookHelper(String modid)
    {
        this.mod = modid;
    }

    public void addRepository()
    {
        this.repository = new FileRepository(this.mod+":"+"book");
        TinkerBook.INSTANCE.addRepository(repository);
    }

    public void addModifierTransformer(String prefix)
    {
        TinkerBook.INSTANCE.addTransformer(new ModifierSectionTransformer(prefix+"modifiers"));
    }

    public void addToolTransformer(String prefix)
    {
        TinkerBook.INSTANCE.addTransformer(new ToolSectionTransformer(prefix+"tools"));
    }

    public FileRepository getRepository() {
        return repository;
    }

    public String getModID() {
        return this.mod;
    }
}
