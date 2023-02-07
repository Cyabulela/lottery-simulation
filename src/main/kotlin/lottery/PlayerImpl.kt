package lottery

import lottery.Result.Won

class PlayerImpl(private val user : User, override var result: Result? = null , private  val formatLotteryTicket: FormatLottery = FormatLotteryTicket()) : Player  , UserInput by UserInputImpl(){

    private val ageRestriction by lazy { 18 }

    override var lotteryNumbers: Set<Int> = emptySet()

    override fun alert() {
        println(
            """
                
                    Congratulation ${user.name}
                    
                    You have won you self \$ ${String.format("%.2f", (result as Won).price)}
         
                """.trimMargin()
        )
    }

    override fun register(lottery: Lottery) {
        if (user.age >= ageRestriction) lottery.deregisterPlayer(this).also { println("\nYou have successfully registered at the lottery\n") }
        else println("\nSorry! But you are under age to play. Try again when you are 18+ years old\n")
    }

    override fun deregist(lottery: Lottery) {
        lottery.deregisterPlayer(this)
        println("\nYou have successfully deregister from the lottery\n")
    }

    override fun `set lottery numbers`(): Set<Int> {
        val lotteryTicketNumbers = getString()
        val bonusBall = getNumber()
        lotteryNumbers = formatLotteryTicket `format lottery ticket` lotteryTicketNumbers
        try {
            if (bonusBall !in 1 until 30) throw BoundaryExceedException()
            (lotteryNumbers as MutableSet<Int>).add(bonusBall)
        } catch (e : BoundaryExceedException) {
            println(e.message)
        }

        return if (lotteryNumbers.size == 6) lotteryNumbers else {
            println("\nInvalid input! please try again\n")
            `set lottery numbers`()
        }
    }

    infix fun checkResultOf(lottery: Lottery){
        println(
            """
                
                    You play your lottery ticket numbers as : ${lotteryNumbers.joinToString(separator = " ")}
                    
                    The current lottery draw is : ${
                lottery.`get winning lottery numbers`().joinToString(separator = " ")
            }
                """.trimIndent()
        )
    }
}