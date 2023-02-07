package lottery

class UserInputImpl : UserInput {
    override fun getNumber(): Int {
        print("Enter your bonus ball number between 1 - 30 : ")
        return readln().toInt()
    }

    override fun getString(): String {
        print("Enter 5 different luck numbers between 1 - 50 [Separate each number by space] : ")
        return readln()
    }
}