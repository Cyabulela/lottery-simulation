package lottery

class BoundaryExceedException(override val message : String = "Your input have exceeded the boundary limit") : Exception()