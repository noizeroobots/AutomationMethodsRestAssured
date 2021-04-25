package n;

import java.util.Objects;

public class TagsItem {
    private String name;
    private int id;

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getId() {
        return id;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof TagsItem) {
                TagsItem tagsItem = (TagsItem) o;
                return id == tagsItem.id && Objects.equals(name, tagsItem.name);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name, id);
    }
}
