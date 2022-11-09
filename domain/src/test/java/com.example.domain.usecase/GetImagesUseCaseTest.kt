package com.example.domain.usecase

import com.example.domain.models.ImagesDto
import com.example.domain.repository.NetworkRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetImagesUseCaseTest {

    private companion object {
        const val TITLE_TEST = 1
        const val DESCRIPTION_TEST = "uuid"
        const val URL_TEST = "firstname"


        const val COUNT_TEST = 1
    }

    private val fakeNetworkRepository = mock<NetworkRepository>()

    @AfterEach
    fun tearDown() {
        Mockito.reset(fakeNetworkRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should return the same list of users as in the repository`() = runTest {
        val testList = listOf(
            ImagesDto(
                TITLE_TEST,
                DESCRIPTION_TEST,
                URL_TEST
            )
        )

        Mockito.`when`(fakeNetworkRepository.getImages(COUNT_TEST)).thenReturn(testList)

        val useCase = GetImagesUseCase(fakeNetworkRepository)
        val actualResult = useCase.execute(COUNT_TEST)

        val expectedResult = listOf(
            ImagesDto(
                TITLE_TEST,
                DESCRIPTION_TEST,
                URL_TEST
            )
        )
        Assertions.assertEquals(expectedResult, actualResult)
    }
}


