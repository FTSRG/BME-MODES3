package hu.bme.mit.inf.modes3.components.bbb.prototypes;

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Stores the pinout header addresses of the BeagleBone Black embedded
 * controller.
 * 
 * The actual configuration file is located at
 * src/main/resources/conf/pinouts.json
 * 
 * @author hegyibalint
 */
class Pinout {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) static var Logger logger

	// the pinout header addresses of the BeagleBone Black embedded controller.
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var Map<String, String[]> headers

	/**
	 * @return the pinout header configuration
	 * @throws Exception if an error happens
	 */
	static def Pinout loadPinoutConfig(ILoggerFactory factory) {
		logger = factory.getLogger(Pinout.name)

		val gson = new Gson
		var InputStreamReader isr = null
		var JsonReader reader = null
		try {
			isr = new InputStreamReader(Pinout.classLoader.getResourceAsStream("resources/pinouts.json"))
			reader = new JsonReader(isr)
			gson.fromJson(reader, Pinout)
		} catch(Exception ex) {
			logger.error(ex.message, ex)
			throw ex
		} finally {
			isr?.close
			reader?.close
		}
	}

	def String[] getHeaderPins(String headerName) {
		val pins = headers.get(headerName.replaceAll("[HL]", ""))
		
		if (headerName.endsWith('L')) {
			#[pins.get(0), pins.get(2)]	
		} else if (headerName.endsWith('H')) {
			#[pins.get(1), pins.get(3)]
		} else {
			pins
		}
		
	}
}
