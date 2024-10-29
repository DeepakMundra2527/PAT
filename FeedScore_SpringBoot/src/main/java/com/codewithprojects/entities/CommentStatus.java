package com.codewithprojects.entities;

import com.codewithprojects.dto.CommentStatusDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CommentStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	private Long commentedUserId;
	
	private String commentedUserName;
	
	private Long postId;
	
	private Long postCreatedUserId;
	
	private boolean readStatus;
	
	public CommentStatusDto getCommentStatusDto() {
		CommentStatusDto commentStatusDto=new CommentStatusDto();
		commentStatusDto.setId(id);
		commentStatusDto.setPostId(postId);
		commentStatusDto.setContent(content);
		commentStatusDto.setCommentedUserId(commentedUserId);
		commentStatusDto.setCommentedUserName(commentedUserName);
		commentStatusDto.setPostCreatedUserId(postCreatedUserId);
		commentStatusDto.setReadStatus(readStatus);
		return commentStatusDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCommentedUserId() {
		return commentedUserId;
	}

	public void setCommentedUserId(Long commentedUserId) {
		this.commentedUserId = commentedUserId;
	}

	public String getCommentedUserName() {
		return commentedUserName;
	}

	public void setCommentedUserName(String commentedUserName) {
		this.commentedUserName = commentedUserName;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getPostCreatedUserId() {
		return postCreatedUserId;
	}

	public void setPostCreatedUserId(Long postCreatedUserId) {
		this.postCreatedUserId = postCreatedUserId;
	}

	public boolean isReadStatus() {
		return readStatus;
	}

	public void setReadStatus(boolean readStatus) {
		this.readStatus = readStatus;
	}
	
}
