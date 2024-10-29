package com.codewithprojects.entities;

import com.codewithprojects.dto.PostDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private boolean liked;
	
	private Long rating;
	
	private Long userId;
	
	@Column(columnDefinition="varbinary(max)")
	private byte[] image;
	
	public int compareTo(Post other) {
        return this.id.compareTo(other.id);
    }

	public PostDto getPostDto() {
		PostDto postDto=new PostDto();
		postDto.setId(id);
		postDto.setTitle(title);
		postDto.setDescription(description);
		postDto.setLiked(liked);
		postDto.setRating(rating);
		postDto.setImage(image);
		postDto.setUserId(userId);
		return postDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}
