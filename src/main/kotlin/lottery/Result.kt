package lottery

sealed interface Result {
    class Won(val price : Double):Result
    object Lost : Result
}