package org.itson.persistencia.implementacion;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.internal.connection.MongoCredentialWithCache;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.itson.persistencia.excepciones.DAOException;

/**
 * Clase que inicializa la conexion con la base de datos
 *
 * @author kim, marki, elmer, yorx
 */
public class Conn {

    /**
     * Nombre de la base de datos
     */
    protected final String BASE_DATOS;

    /**
     *
     * @param BASE_DATOS
     */
    protected Conn(String BASE_DATOS) {
        this.BASE_DATOS = BASE_DATOS;
    }

    /**
     * Generas una conexion con la base de datos
     *
     * @return Conexion a la base de datos
     */
    protected MongoDatabase getBaseDatos() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase(BASE_DATOS);
        return database;
    }

}
