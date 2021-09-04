object Hamming {

    def distance(strandA: String, strandB: String) = (strandA, strandB) match {
        case (strandA, strandB) if strandA.length == strandB.length => Some(_distance(strandA, strandB))
        case _ => None
    }
    
    private def _distance(strandA: String, strandB: String): Int =
        (strandA zip strandB).count(t => t._1 != t._2)

}
