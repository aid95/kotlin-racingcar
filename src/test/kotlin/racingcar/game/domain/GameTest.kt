package racingcar.game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.game.vo.CarHistory
import racingcar.game.vo.GameParameter

internal class GameTest {
    @Test
    fun `모두 움직이지 않는 경우 게임 실행 테스트`() {

        // given
        val nameOfCar = "name1,name2,name3"
        val numOfGame = "3"

        // when
        val param = GameParameter.initParameter(nameOfCar, numOfGame)
        val moveCondition = { 1 }
        val result = Game.start(param, moveCondition)

        // then
        val lastRoundHistory: List<CarHistory> = result.history.last().roundHistory
        assertThat(result.history.size).isEqualTo(3)
        assertThat(lastRoundHistory)
            .extracting("position")
            .containsOnly(0)
    }

    @Test
    fun `모두 움직이는 경우 게임 실행 테스트`() {
        // given
        val nameOfCar = "name1,name2,name3"
        val numOfGame = "3"

        // when
        val param = GameParameter.initParameter(nameOfCar, numOfGame)
        val moveCondition = { 6 }
        val result = Game.start(param, moveCondition)

        // then
        val lastRoundHistory: List<CarHistory> = result.history.last().roundHistory
        assertThat(result.history.size).isEqualTo(3)
        assertThat(lastRoundHistory)
            .extracting("position")
            .containsOnly(3)
    }
}