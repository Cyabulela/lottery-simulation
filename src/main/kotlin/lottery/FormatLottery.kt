package lottery

interface FormatLottery {
    infix fun `format lottery ticket`(lotteryString : String) : Set<Int>
}