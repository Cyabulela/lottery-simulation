package lottery

abstract class Lottery {

    protected val listOfPlayers : ArrayList<Player> = ArrayList()
    protected var winningPlayers : List<Player> = emptyList()
    fun registerPlayer(player: Player){
        listOfPlayers.add(player)
    }

    fun deregisterPlayer(player: Player){
        listOfPlayers.remove(player)
    }

    protected fun alertWinners() {
        for (player in winningPlayers) {
            player.alert()
        }
    }

    abstract fun `get winning lottery numbers`() : Set<Int>

    abstract fun startLottery()
}