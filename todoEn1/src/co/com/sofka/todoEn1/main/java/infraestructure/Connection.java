package co.com.sofka.kardexTd1.infraestructure;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

import com.mongodb.MongoClient;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
public class Connection {
	
	@Produces
    @ApplicationScoped
	public MongoClient mongoClient() {
        MongoClient mongo = new MongoClient("localhost", 27017);
        return mongo;
    }
}
