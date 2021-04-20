package n;

import java.util.List;
import java.util.Objects;

public class PetPost{
	private List<String> photoUrls;
	private String name;
	private int id;
	private Category category;
	private List<TagsItem> tags;
	private String status;

	public void setPhotoUrls(List<String> photoUrls){
		this.photoUrls = photoUrls;
	}

	public List<String> getPhotoUrls(){
		return photoUrls;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(Category category){
		this.category = category;
	}

	public Category getCategory(){
		return category;
	}

	public void setTags(List<TagsItem> tags){
		this.tags = tags;
	}

	public List<TagsItem> getTags(){
		return tags;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PetPost)) return false;
		PetPost petPost = (PetPost) o;
		return id == petPost.id && Objects.equals(photoUrls, petPost.photoUrls) && Objects.equals(name, petPost.name) && Objects.equals(category, petPost.category) && Objects.equals(tags, petPost.tags) && Objects.equals(status, petPost.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(photoUrls, name, id, category, tags, status);
	}
}