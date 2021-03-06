package com.techathon.lockedin.executors.github;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"action",
"number",
"pull_request"
})
@Table(name = "pr_opened_model")
@Entity
public class PrOpenedModel {

@JsonProperty("action")
private String action;
@JsonProperty("number")
private Integer number;

@JsonProperty("comment")
@Transient
private GitHubComments comment;

@JsonProperty("review")
@Transient
private GitHubReviewComments review;

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@JsonProperty("pull_request")
@OneToOne(cascade=CascadeType.ALL)
private PullRequest pullRequest;


 

@JsonProperty("action")
public String getAction() {
return action;
}

@JsonProperty("action")
public void setAction(String action) {
this.action = action;
}

@JsonProperty("number")
public Integer getNumber() {
return number;
}

@JsonProperty("number")
public void setNumber(Integer number) {
this.number = number;
}

@JsonProperty("pull_request")
public PullRequest getPullRequest() {
return pullRequest;
}

@JsonProperty("pull_request")
public void setPullRequest(PullRequest pullRequest) {
this.pullRequest = pullRequest;
}

 

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public GitHubComments getComment() {
	return comment;
}

public void setComment(GitHubComments comment) {
	this.comment = comment;
}

public GitHubReviewComments getReview() {
	return review;
}

public void setReview(GitHubReviewComments review) {
	this.review = review;
}

 

}