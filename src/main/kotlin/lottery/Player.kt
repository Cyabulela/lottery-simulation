package lottery

interface Player{
    var lotteryNumbers : Set<Int>
    var result : Result?
    fun `set lottery numbers`(): Set<Int>
    fun `set lottery numbers`(numbers : Set<Int>) = if (numbers.size != 6) throw BoundaryExceedException() else lotteryNumbers = numbers
    fun alert()
    fun register(lottery: Lottery)
    fun deregist(lottery: Lottery)
}