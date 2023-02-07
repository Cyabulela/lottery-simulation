import lottery.*

fun main() {
    val userRegistrationInput : UserInput = UserRegistrationInput()

    val name = userRegistrationInput.getString()
    val age = userRegistrationInput.getNumber()

    val user = User(name = name , age = age)

    val player = PlayerImpl(user =  user)

    val playPowerBall : Lottery = PlayPowerBall

    player.register(lottery = playPowerBall)

    player.`set lottery numbers`(setOf(2 , 3 , 5 , 7 , 12 , 4))

    playPowerBall.startLottery()

    player checkResultOf playPowerBall
}