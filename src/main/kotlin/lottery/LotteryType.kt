package lottery

interface LotteryType {
    fun `player result`(numberOfBalls : Int, bonusBallMatched : Boolean) : Result
}