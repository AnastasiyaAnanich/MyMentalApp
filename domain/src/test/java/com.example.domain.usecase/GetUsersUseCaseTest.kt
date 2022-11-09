package com.example.domain.usecase

import com.example.domain.models.UserDto
import com.example.domain.repository.NetworkRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUsersUseCaseTest {

    private companion object {
        const val ID_TEST = 1
        const val UUID_TEST = "uuid"
        const val FIRSTNAME_TEST = "firstname"
        const val LASTNAME_TEST = "lastname"
        const val USERNAME_TEST = "username"
        const val PASSWORD_TEST = "password"
        const val EMAIL_TEST = "email"
        const val IP_TEST = "ip"
        const val MAC_ADDRESS_TEST = "macAddress"
        const val WEBSITE_TEST = "website"
        const val IMAGE_TEST = "image"

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
            UserDto(
                ID_TEST,
                UUID_TEST,
                FIRSTNAME_TEST,
                LASTNAME_TEST,
                USERNAME_TEST,
                PASSWORD_TEST,
                EMAIL_TEST,
                IP_TEST,
                MAC_ADDRESS_TEST,
                WEBSITE_TEST,
                IMAGE_TEST
            )
        )

        Mockito.`when`(fakeNetworkRepository.getUsers(COUNT_TEST)).thenReturn(testList)

        val useCase = GetUsersUseCase(fakeNetworkRepository)
        val actualResult = useCase.execute(COUNT_TEST)

        val expectedResult = listOf(
            UserDto(
                ID_TEST,
                UUID_TEST,
                FIRSTNAME_TEST,
                LASTNAME_TEST,
                USERNAME_TEST,
                PASSWORD_TEST,
                EMAIL_TEST,
                IP_TEST,
                MAC_ADDRESS_TEST,
                WEBSITE_TEST,
                IMAGE_TEST
            )
        )
        Assertions.assertEquals(expectedResult, actualResult)
    }
}


