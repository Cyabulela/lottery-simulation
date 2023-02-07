package lottery

object PlayPowerBall : Lottery() , LotteryEngine by LotteryBallGeneratorEngine() {

    private var winningLotteryNumbers = emptySet<Int>()

    override fun `get winning lottery numbers`(): Set<Int> {
        return winningLotteryNumbers
    }

    override fun startLottery() {
        winningLotteryNumbers = `generate lottery numbers`()
        val winningNumber = WinningNumbers(
            generatedLottery = winningLotteryNumbers,
            listOfPlayers = listOfPlayers,
            lotteryType = PowerBall()
        )
        winningPlayers = winningNumber.winningPlayers()
        alertWinners()
    }
}