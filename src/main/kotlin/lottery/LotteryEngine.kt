package lottery

interface LotteryEngine {
    fun `generate lottery numbers`() : Set<Int>
}
