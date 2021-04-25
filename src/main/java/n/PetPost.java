package n;

import java.util.List;
import java.util.Objects;

public class PetPost {
    private List<String> photoUrls;
    private String name;
    private int id;
    private Category category;
    private List<TagsItem> tags;
    private String status;

    public final void setPhotoUrls(final List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public final List<String> getPhotoUrls() {
        return photoUrls;
    }

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

    public final void setCategory(final Category category) {
        this.category = category;
    }

    public final Category getCategory() {
        return category;
    }

    public final void setTags(final List<TagsItem> tags) {
        this.tags = tags;
    }

    public final List<TagsItem> getTags() {
        return tags;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

    public final String getStatus() {
        return status;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof PetPost) {
                PetPost petPost = (PetPost) o;
                return id == petPost.id && Objects.equals(photoUrls, petPost.photoUrls) && Objects.equals(name, petPost.name) && Objects.equals(category, petPost.category) && Objects.equals(tags, petPost.tags) && Objects.equals(status, petPost.status);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public final int hashCode() {
        return Objects.hash(photoUrls, name, id, category, tags, status);
    }
}