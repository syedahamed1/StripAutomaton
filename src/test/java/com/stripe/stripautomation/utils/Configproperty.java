package com.stripe.stripautomation.utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources({"file:src/test/resources/properties/config.properties"})
public interface Configproperty extends Config{
	
	
	@Key("BaseURL")
	String baseURI();
	
	@Key("Basepath")
	String basePATH();
	
	@Key("seceretkey")
	String authkey();

}
