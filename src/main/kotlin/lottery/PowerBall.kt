package lottery

class PowerBall : LotteryType {
    private val bonusBallMatchedPrize by lazy { 2000 }
    private val pricePerBall by lazy { 50 }
    override fun `player result`(numberOfBalls: Int, bonusBallMatched: Boolean): Result {
        val prize = if (bonusBallMatched) bonusBallMatchedPrize else 0
        return if (numberOfBalls >= 2 || bonusBallMatched) Result.Won(price = (prize + (pricePerBall * numberOfBalls)).toDouble())
        else Result.Lost
    }
}