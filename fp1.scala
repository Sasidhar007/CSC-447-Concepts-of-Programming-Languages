// GENERATED
/* INSTRUCTIONS
 *
 * Complete the exercises below.  For each "EXERCISE" comment, add
 * code immediately below the comment.
 *
 * Please see README.md for instructions, including compilation and testing.
 * 
 * GRADING
 * 
 * 1. Submissions MUST compile using SBT with UNCHANGED configuration and tests with no
 *    compilation errors.  Submissions with compilation errors will receive 0 points.
 *    Note that refactoring the code will cause the tests to fail.
 *
 * 2. You MUST NOT edit the SBT configuration and tests.  Altering it in your submission will
 *    result in 0 points for this assignment.
 *
 * 3. You MUST NOT use while loops or (re)assignment to variables (you can use "val" declarations,
 *    but not "var" declarations).  You must use recursion instead.
 *
 * 4. You may declare auxiliary functions if you like.
 *
 * SUBMISSION
 *
 * 1. Upload this file to D2L before the deadline.
 *
 * 2. Late submissions will not be permitted because solutions will be discussed in class.
 * 
 */

object fp1 {

  // EXAMPLE: here is the definition of the factorial function.
  def fact (n : Int) : Int = {
    if (n <= 1) 
      1
    else 
      n * fact (n - 1)
  }

  // EXERCISE 1: complete the following definition, so that factTest is the list of integers
  // List(1,2,6,24,120).  You must call the "fact" function (five times) defined above instead of
  // hardcoding the numbers 1,2,6,24,120.
  val factTest : List[Int] = {
	val l = List(1,2,3,4,5)
    l.map(fact)
  }

  // EXERCISE 2: complete the following definition of the Fibonacci function.
  def fib (n : Int) : Int = {
    if ( n <= 1)
		n
	else
		fib(n-1) + fib(n-2)
  }

  // EXERCISE 3: declare the identifier "p1" with a pair consisting of the Int 7 and the String
  // "hello"
  val p1 : (Int, String) = {
  
	(7 , "hello")
	
  }

  // EXERCISE 4: declare the identifier "t1" with a triple consisting of the Int 7, the String
  // "hello", and the Boolean false
  val t1 : (Int, String, Boolean) = {
	(7 , "hello" , false)
  }

  // EXERCISE 5: write a function "swap" that takes a pair of an Int and a String, and returns a
  // pair of a String and an Int (with the values from the pair passed an argument.  E.g., swap (p1)
  // should return ("hello", 7).  You can use "p._1" and "p._2" to access the first and second
  // components of a pair.
  def swap (p:(Int,String)) : (String,Int) = {
    // TODO: Provide definition here.
    (p._2,p._1)
  }

  // EXERCISE 6: write a function "sum" that takes a list of integers and sums them.  As with all of
  // the exercises in this assignment, your function MUST be recursive and MUST NOT use a while
  // loop.
  def sum (xs : List[Int]) : Int = {
    xs match {
	case Nil => 0
	case x :: tail => sum(tail) + x
	}
  }

  // EXERCISE 7: given the definition of the function "sumTailRecursiveAux" below, complete the
  // definition of the function "sumTailRecursive" so that it also sums a list of integers.  You
  // must not alter the definition of "sumTailRecursiveAux".  Your definition for "sumTailRecursive"
  // must call "sumTailRecursiveAux" directly, and must not call "sum"
  def sumTailRecursiveAux (accumulator : Int, xs : List[Int]) : Int = {
    xs match {
      case Nil => accumulator
      case y::ys => sumTailRecursiveAux (accumulator + y, ys)
    }
  }

  def sumTailRecursive (xs : List[Int]) : Int = {
    sumTailRecursiveAux(0,xs)
  }

  // EXERCISE 8: complete the following definition of the function "max" that finds the maximum
  // integer in a list of integers.  Note that no value can be returned when the list is empty,
  // hence the "NoSuchElementException".  Your function MUST be recursive and MUST NOT use a while
  // loop.  You MUST NOT use the "max" method on lists, but can use the "max" method on integers.
  def max (xs : List[Int]) : Int = {
  xs match{
	case Nil => throw new java.util.NoSuchElementException
	case notNil => xs.reduceLeft((x,y) => if (x > y) x else y)
		}
	}
  

  // EXERCISE 9: given the definition of the function "maxTailRecursive" below, complete the
  // definition of the function "maxTailRecursiveAux" so that "maxTailRecursive" also finds the
  // maximum of a list of integers.  You must not alter the definition of "maxTailRecursive".  Your
  // definition for "maxTailRecursiveAux" must be recursive and not use while loops.
  def maxTailRecursiveAux (accumulator : Int, xs : List[Int]) : Int = {
    if(xs.isEmpty) {accumulator}
	else if (xs.head > accumulator){ maxTailRecursiveAux(xs.head,xs.tail)}
	else { maxTailRecursiveAux(accumulator,xs.tail)}
	}
  

  def maxTailRecursive (xs : List[Int]) : Int = {
    xs match {
      case Nil => throw new RuntimeException () 
      case y::ys => maxTailRecursiveAux (y, ys)
    }
  }

  // EXERCISE 10: Write a recursive function "otpu" ("upto" backwards) that takes two Int parameters
  // "start" and "end" and produces a "List[Int]" that counts DOWN from "start" to "end" (inclusive
  // at both ends) one at a time.  If "start < end", the empty list must be returned.
  def otpu (start : Int, end : Int) : List[Int] = {
    if(start>=end) start :: otpu(start-1,end)
	else List()
  }
}

