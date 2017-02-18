object MyModule {
  def abs(n: Int): Int = 
    if (n < 0) -n
    else n
  
    
  def factorial(n: Int): Int = {
      def go(n: Int, acc: Int) : Int = 
        if (n <= 0) acc
        else go(n-1, n*acc)
       
        go(n, 1)
    }
  
  def findFirst[A, B](as: Array[A], key: B, p: (A, B) => Boolean): Int = {
    def loop(n: Int): Int =
      if(n >= as.length) -1
      else if (p(as(n), key)) n
      else loop(n + 1)
    
      loop(0)
  }
  
  def eq[A, B](a: A, b: B): Boolean =
    a == b 
  
  def formatResult(name: String, n:Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }
  
  private def formatAbs(x: Int) = {
      val msg = "The absolute value of %d is %d"
      msg.format(x, abs(x))
    }
  
  private def formatFactorial(x: Int) = {
      val msg = "The factorial value of %d is %d"
      msg.format(x, factorial(x))
    }
  
  private def formatFindFirst[A, B](ss: Array[A], key: B) = {
      val msg = "The value \"%s\" is at location %d"
      msg.format(key, findFirst(ss, key, eq))
    }
    
  def main(args: Array[String]) : Unit = 
    //println(formatAbs(-42))
    //println(formatFactorial(7))
    
    ///println(formatResult("absolute value", -24, abs))
    //println(formatResult("factorial", 14, factorial))
  
  println(formatFindFirst(Array("this", "is", "a", "test"), "test"))
  println(formatFindFirst(Array(2, 4, 5, 6), 4))
  
}