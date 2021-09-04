import scala.language.dynamics

// Pretty much bobahop's solution:
// https://exercism.io/tracks/scala/exercises/space-age/solutions/765878bcc0984b4eb88e45af8b590a29
// Includes some more information for me
object SpaceAge extends Dynamic {

	private val EarthYearInSeconds = 31557600.0
	
	private val ConversionFactors: Map[String, Double] = Map(
		"Earth" -> 1.0,
		"Mercury" -> 0.2408467,
		"Venus" -> 0.61519726,
		"Mars" -> 1.8808158,
		"Jupiter" -> 11.862615,
		"Saturn" -> 29.447498,
		"Uranus" -> 84.016846,
		"Neptune" -> 164.79132,
	)
	
	// Convert seconds to planet years,
	// defaulting to earth years for unknown planets.
	private def calculateAge(planet: String, seconds: Double): Double =
		seconds / EarthYearInSeconds / ConversionFactors.getOrElse(planet, 1.0)
	
	// Catch method calls, remove the "on" part, 
	// process the data, and return the result.
	def applyDynamic(method: String)(seconds: Double): Double =
		calculateAge(method.substring(2), seconds)

}
