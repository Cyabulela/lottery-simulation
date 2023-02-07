package lottery

class UserRegistrationInput : UserInput {
    override fun getNumber(): Int {
        print("Enter your age : ")
        return readln().toInt()
    }

    override fun getString(): String {
        print("Enter your name : ")
        return readln()
    }
}