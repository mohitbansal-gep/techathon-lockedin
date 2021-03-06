package com.techathon.lockedin.executors.github;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"login",
"avatar_url",
})
@Table(name="requested_reviewers")
@Entity
public class RequestedReviewers {

 
@Column(name="review_id")
private Integer reviewRequestorId;
	
   @Id
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("login")
	private String login;
	
	@JsonProperty("avatar_url")
	private String avatarUrl;

	
	@JsonProperty("comments")
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="github_comment_id")
	private List<GitHubComments> comments;
	
	
	
	public Integer getReviewRequestorId() {
		return reviewRequestorId;
	}

	public void setReviewRequestorId(Integer reviewRequestorId) {
		this.reviewRequestorId = reviewRequestorId;
	}

	public List<GitHubComments> getComments() {
		return comments;
	}

	public void setComments(List<GitHubComments> comments) {
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	
}
