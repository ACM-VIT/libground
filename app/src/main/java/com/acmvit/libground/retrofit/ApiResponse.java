package com.acmvit.libground.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

	@SerializedName("author")
	private String author;

	@SerializedName("length")
	private int length;

	@SerializedName("_id")
	private String id;

	@SerializedName("content")
	private String content;

	@SerializedName("tags")
	private List<String> tags;

	public String getAuthor(){
		return author;
	}

	public int getLength(){
		return length;
	}

	public String getId(){
		return id;
	}

	public String getContent(){
		return content;
	}

	public List<String> getTags(){
		return tags;
	}
}