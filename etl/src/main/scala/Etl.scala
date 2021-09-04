object Etl {

    def transform(map: Map[Int, Seq[String]]): Map[String, Int] =
        // Return a new map by iterating over the entries, applying the
        // function to an entry, which returns a list of entries, and
        // finally inserting all returned entries into the new map.
        map.flatMap {
            case (score, letters) => letters.map(_.toLowerCase -> score)
        }

}
