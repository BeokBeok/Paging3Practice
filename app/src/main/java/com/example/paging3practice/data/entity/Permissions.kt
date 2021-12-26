package com.example.paging3practice.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Permissions(

	@SerialName("pull")
	val pull: Boolean? = null,

	@SerialName("maintain")
	val maintain: Boolean? = null,

	@SerialName("admin")
	val admin: Boolean? = null,

	@SerialName("triage")
	val triage: Boolean? = null,

	@SerialName("push")
	val push: Boolean? = null
)