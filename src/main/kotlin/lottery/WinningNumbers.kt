package lottery

import lottery.Result.Won

class WinningNumbers(private val generatedLottery : Set<Int> , private val listOfPlayers : List<Player> , private val lotteryType: LotteryType) {
    fun winningPlayers() : List<Player> = buildList {
        for (player in listOfPlayers){
            val matchedNumbers = player.lotteryNumbers.take(5).filter { number ->
                number in generatedLottery.take(5)
            }

            val bonusBallMatched = matchedNumbers.last() == generatedLottery.last()

            val playerResult = lotteryType.`player result`(numberOfBalls = matchedNumbers.size , bonusBallMatched = bonusBallMatched)

            player.result = playerResult

            if (player.result is Won) add(player)
        }
    }
}