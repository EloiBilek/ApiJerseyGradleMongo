/**
 * 
 */
package com.apijerseygradlemongo.config.producers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.apijerseygradlemongo.config.qualifiers.InjectableProperties;
import com.apijerseygradlemongo.config.qualifiers.Property;
import com.mongodb.MongoClient;

/**
 * Producer Mongo Datastore conection and Property load file.
 * 
 * @author eloibilek@gmail.com
 * 
 */
public class ApplicationProducer {

	@Produces
	@ApplicationScoped
	public Datastore datastore(@Property("dbHost") String mongoDbHost, @Property("dbPort") Integer mongoDbPort,
			@Property("dbName") String mongoDbName) throws Exception {

		// If set user and passwd in MongoDB, use:
		// MongoClientURI uri = new MongoClientURI(@Property("mongoDbUri")
		// String mongoDbUri);
		final MongoClient mongoClient = new MongoClient(mongoDbHost, mongoDbPort);

		final Morphia morphia = new Morphia();
		morphia.mapPackage("com.apijerseygradlemongo.model.entity");

		final Datastore datastore = morphia.createDatastore(mongoClient, mongoDbName);
		datastore.ensureIndexes();
		return datastore;
	}

	@Produces
	@Property(value = "")
	public String property(@InjectableProperties Map<String, String> properties, InjectionPoint injectionPoint) {
		final Property property = injectionPoint.getAnnotated().getAnnotation(Property.class);
		return properties.get(property.value());
	}

	@ApplicationScoped
	@Produces
	@InjectableProperties
	public Map<String, String> properties() throws IOException {
		Map<String, String> map = new HashMap<>();
		final ResourceBundle bundle = ResourceBundle.getBundle("application");
		bundle.keySet().forEach(key -> map.put(key, bundle.getString(key)));
		return map;
	}
}
