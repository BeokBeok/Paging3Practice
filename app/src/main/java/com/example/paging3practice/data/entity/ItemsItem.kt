package com.example.paging3practice.data.entity

import com.example.paging3practice.data.mapper.DataToDomainMapper
import com.example.paging3practice.domain.model.Repo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemsItem(

    @SerialName("allow_forking")
	val allowForking: Boolean? = null,

    @SerialName("stargazers_count")
	val stargazersCount: Int? = null,

    @SerialName("is_template")
	val isTemplate: Boolean? = null,

    @SerialName("pushed_at")
	val pushedAt: String? = null,

    @SerialName("subscription_url")
	val subscriptionUrl: String? = null,

    @SerialName("language")
	val language: String? = null,

    @SerialName("branches_url")
	val branchesUrl: String? = null,

    @SerialName("issue_comment_url")
	val issueCommentUrl: String? = null,

    @SerialName("labels_url")
	val labelsUrl: String? = null,

    @SerialName("score")
	val score: Double? = null,

    @SerialName("subscribers_url")
	val subscribersUrl: String? = null,

    @SerialName("permissions")
	val permissions: Permissions? = null,

    @SerialName("releases_url")
	val releasesUrl: String? = null,

    @SerialName("svn_url")
	val svnUrl: String? = null,

    @SerialName("id")
	val id: Int? = null,

    @SerialName("forks")
	val forks: Int? = null,

    @SerialName("archive_url")
	val archiveUrl: String? = null,

    @SerialName("git_refs_url")
	val gitRefsUrl: String? = null,

    @SerialName("forks_url")
	val forksUrl: String? = null,

    @SerialName("visibility")
	val visibility: String? = null,

    @SerialName("statuses_url")
	val statusesUrl: String? = null,

    @SerialName("ssh_url")
	val sshUrl: String? = null,

    @SerialName("license")
	val license: License? = null,

    @SerialName("full_name")
	val fullName: String? = null,

    @SerialName("size")
	val size: Int? = null,

    @SerialName("languages_url")
	val languagesUrl: String? = null,

    @SerialName("html_url")
	val htmlUrl: String? = null,

    @SerialName("collaborators_url")
	val collaboratorsUrl: String? = null,

    @SerialName("clone_url")
	val cloneUrl: String? = null,

    @SerialName("name")
	val name: String? = null,

    @SerialName("pulls_url")
	val pullsUrl: String? = null,

    @SerialName("default_branch")
	val defaultBranch: String? = null,

    @SerialName("hooks_url")
	val hooksUrl: String? = null,

    @SerialName("trees_url")
	val treesUrl: String? = null,

    @SerialName("tags_url")
	val tagsUrl: String? = null,

    @SerialName("private")
	val jsonMemberPrivate: Boolean? = null,

    @SerialName("contributors_url")
	val contributorsUrl: String? = null,

    @SerialName("has_downloads")
	val hasDownloads: Boolean? = null,

    @SerialName("notifications_url")
	val notificationsUrl: String? = null,

    @SerialName("open_issues_count")
	val openIssuesCount: Int? = null,

    @SerialName("description")
	val description: String? = null,

    @SerialName("created_at")
	val createdAt: String? = null,

    @SerialName("watchers")
	val watchers: Int? = null,

    @SerialName("keys_url")
	val keysUrl: String? = null,

    @SerialName("deployments_url")
	val deploymentsUrl: String? = null,

    @SerialName("has_projects")
	val hasProjects: Boolean? = null,

    @SerialName("archived")
	val archived: Boolean? = null,

    @SerialName("has_wiki")
	val hasWiki: Boolean? = null,

    @SerialName("updated_at")
	val updatedAt: String? = null,

    @SerialName("comments_url")
	val commentsUrl: String? = null,

    @SerialName("stargazers_url")
	val stargazersUrl: String? = null,

    @SerialName("disabled")
	val disabled: Boolean? = null,

    @SerialName("git_url")
	val gitUrl: String? = null,

    @SerialName("has_pages")
	val hasPages: Boolean? = null,

    @SerialName("owner")
	val owner: Owner? = null,

    @SerialName("commits_url")
	val commitsUrl: String? = null,

    @SerialName("compare_url")
	val compareUrl: String? = null,

    @SerialName("git_commits_url")
	val gitCommitsUrl: String? = null,

    @SerialName("topics")
	val topics: List<String?>? = null,

    @SerialName("blobs_url")
	val blobsUrl: String? = null,

    @SerialName("git_tags_url")
	val gitTagsUrl: String? = null,

    @SerialName("merges_url")
	val mergesUrl: String? = null,

    @SerialName("downloads_url")
	val downloadsUrl: String? = null,

    @SerialName("has_issues")
	val hasIssues: Boolean? = null,

    @SerialName("url")
	val url: String? = null,

    @SerialName("contents_url")
	val contentsUrl: String? = null,

    @SerialName("mirror_url")
	val mirrorUrl: String? = null,

    @SerialName("milestones_url")
	val milestonesUrl: String? = null,

    @SerialName("teams_url")
	val teamsUrl: String? = null,

    @SerialName("fork")
	val fork: Boolean? = null,

    @SerialName("issues_url")
	val issuesUrl: String? = null,

    @SerialName("events_url")
	val eventsUrl: String? = null,

    @SerialName("issue_events_url")
	val issueEventsUrl: String? = null,

    @SerialName("assignees_url")
	val assigneesUrl: String? = null,

    @SerialName("open_issues")
	val openIssues: Int? = null,

    @SerialName("watchers_count")
	val watchersCount: Int? = null,

    @SerialName("node_id")
	val nodeId: String? = null,

    @SerialName("homepage")
	val homepage: String? = null,

    @SerialName("forks_count")
	val forksCount: Int? = null
) : DataToDomainMapper<Repo> {

    override fun toModel(): Repo = Repo(
        id = id ?: -1,
        fullName = fullName ?: ""
    )
}