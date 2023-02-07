package lottery

class FormatLotteryTicket : FormatLottery {

    override fun `format lottery ticket`(lotteryString: String): Set<Int>{
        val splitStringNumbers = lotteryString.split(' ' , ignoreCase = true)
        val lotteryNumbers : List<Int>
        try {
            lotteryNumbers = splitStringNumbers.map { stringNumber -> stringNumber.toInt() }
            val invalidNumber = lotteryNumbers.any { number -> number !in BallsRange.normalBallRange }
            if (invalidNumber) throw BoundaryExceedException()
        }
        catch (e : BoundaryExceedException) {
            e.printStackTrace()
            return emptySet()
        }
        catch (e : Exception) {
            println(
                """
                    Seems like you have supplied invalid input
                """.trimIndent()
            )
            return emptySet()
        }
        return  lotteryNumbers.filter { number -> number in BallsRange.normalBallRange }.sorted().toSet()
    }
}