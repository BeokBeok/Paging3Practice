package com.example.paging3practice.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class License(

	@SerialName("name")
	val name: String? = null,

	@SerialName("spdx_id")
	val spdxId: String? = null,

	@SerialName("key")
	val key: String? = null,

	@SerialName("url")
	val url: String? = null,

	@SerialName("node_id")
	val nodeId: String? = null
)