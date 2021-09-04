// Based on https://exercism.io/tracks/scala/exercises/grade-school/solutions/2bd5fed8c4f4413ea9d10d52260cd7ed
class School {
  type DB = Map[Int, Seq[String]]
  
  private var theDb: DB = Map.empty

  def add(name: String, g: Int) = theDb = theDb.updated(g, grade(g) :+ name)

  def db: DB = theDb

  def grade(g: Int): Seq[String] = theDb.getOrElse(g, Seq.empty)

  def sorted: DB = Map(theDb.toSeq.sortBy(_._1):_*).mapValues(_.sorted)
}

