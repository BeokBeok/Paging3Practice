package com.example.paging3practice.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepoSearchResponse(

	@SerialName("total_count")
	val totalCount: Int? = null,

	@SerialName("incomplete_results")
	val incompleteResults: Boolean? = null,

	@SerialName("items")
	val items: List<ItemsItem> = emptyList()
)
