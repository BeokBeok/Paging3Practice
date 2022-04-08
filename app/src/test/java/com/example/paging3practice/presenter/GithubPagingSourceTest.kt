package com.example.paging3practice.presenter

import androidx.paging.PagingSource
import com.example.paging3practice.domain.model.Repo
import com.example.paging3practice.domain.usecase.FetchGithubRepositoriesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import java.net.UnknownHostException
import kotlin.test.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GithubPagingSourceTest {
    private val useCase: FetchGithubRepositoriesUseCase = mockk(relaxed = true)
    private lateinit var pagingSource: GithubPagingSource

    @Before
    fun setup() {
        pagingSource = GithubPagingSource(fetchGithubRepositoriesUseCase = useCase)
    }

    @Test
    fun `초기 데이터를_불러옵니다`() = runBlocking {
        // given
        val mockResponse = listOf(
            Repo(id = 0, fullName = "a"),
            Repo(id = 1, fullName = "b"),
            Repo(id = 2, fullName = "c"),
        )
        coEvery {
            useCase.execute(page = 1, perPage = 3)
        } returns mockResponse

        // when - then
        assertEquals(
            expected = PagingSource.LoadResult.Page(
                data = mockResponse,
                prevKey = null,
                nextKey = 1
            ),
            actual = pagingSource.load(
                params = PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )
        )
    }

    @Test
    fun `스크롤 시_다음 데이터를_불러옵니다`() = runBlocking {
        // given
        val mockResponse = listOf(
            Repo(id = 3, fullName = "d"),
            Repo(id = 4, fullName = "e"),
            Repo(id = 5, fullName = "f"),
        )
        coEvery {
            useCase.execute(page = 2, perPage = 3)
        } returns mockResponse

        // when - then
        assertEquals(
            expected = PagingSource.LoadResult.Page(
                data = mockResponse,
                prevKey = 1,
                nextKey = 2
            ),
            actual = pagingSource.load(
                params = PagingSource.LoadParams.Refresh(
                    key = 2,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )
        )
    }

    @Test
    fun `데이터 로드 중_에러가 발생하면_Error를 리턴합니다`() = runBlocking {
        // given
        val networkException = UnknownHostException()
        coEvery {
            useCase.execute(page = 1, perPage = 3)
        } throws networkException

        // when - then
        assertEquals(
            expected = PagingSource.LoadResult.Error(throwable = networkException),
            actual = pagingSource.load(
                params = PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )
        )
    }
}
