// Heavily influenced by aaylward's solution, due to which I
// learned about pattern matching with if-expressions and the
// true-uppercase trick.
// https://exercism.io/tracks/scala/exercises/bob/solutions/3e94c35d30f845139e81b15518035f16
object Bob {
  
  // This function uses that we only really have uppercase if
  // the string is equal to its own uppercase version, but NOT
  // equal to its own lowercase version. This is important
  // for cases like "4?", ":) ?" and "1, 2, 3".
  private def isTrueUpperCase(statement: String) : Boolean = 
    statement != statement.toLowerCase && statement == statement.toUpperCase
  
  private def isQuestion(statement: String) : Boolean = 
    statement.trim.endsWith("?")
  
  def response(statement: String): String =
    statement match {
        case x if isTrueUpperCase(x) && isQuestion(x) => "Calm down, I know what I'm doing!"
        case x if isQuestion(x) => "Sure."
        case x if isTrueUpperCase(x) => "Whoa, chill out!"
        case x if x.trim.isEmpty => "Fine. Be that way!"
        case _ => "Whatever."
    }
}
