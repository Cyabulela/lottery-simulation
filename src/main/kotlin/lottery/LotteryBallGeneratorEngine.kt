package lottery

import kotlin.random.Random

class LotteryBallGeneratorEngine : LotteryEngine{

    override fun `generate lottery numbers`(): Set<Int> {
        return buildSet {
            while (this.size != 5) {
                val balls = Random.nextInt(BallsRange.normalBallRange.first , BallsRange.normalBallRange.max() + 1)
                add(balls)
            }
            while (this.size != 6){
                val bonusBall = Random.nextInt(BallsRange.bonusBallRange.first , BallsRange.normalBallRange.max() + 1)
                add(bonusBall)
            }
        }
    }
}