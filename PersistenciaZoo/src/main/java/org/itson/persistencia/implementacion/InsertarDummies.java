/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.implementacion;

import ObjNegocio.Especie;
import ObjNegocio.Guia;
import ObjNegocio.Habitat;
import ObjNegocio.Zona;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.itson.persistencia.excepciones.DAOException;

/**
 * Inserta datos dummies
 *
 * @author kim, marki, elmer, yorx
 */
public class InsertarDummies extends Conn {

    /**
     * Constructor que recibe la base a trabajar
     *
     * @param BASE_DATOS Nombre de la base
     */
    public InsertarDummies(String BASE_DATOS) {
        super(BASE_DATOS);
    }
    /**
     * Coleccion de guias
     */
    MongoCollection<Guia> guias = getBaseDatos().getCollection("guias", Guia.class);
    /**
     * Coleccion de zonas
     */
    MongoCollection<Zona> zonas = getBaseDatos().getCollection("zonas", Zona.class);
    /**
     * Coleccion de habitats
     */
    MongoCollection<Habitat> habitats = getBaseDatos().getCollection("habitats", Habitat.class);
    /**
     * Coleccion de especies
     */
    MongoCollection<Especie> especies = getBaseDatos().getCollection("especies", Especie.class);

    /**
     * Fecha generica
     */
    Date tiempo = new Date();
    /**
     * Guia
     */
    Guia guia1 = new Guia("6441223311", "Nainari", "410colonia", "2010", "Juan", "Robles", "Pérez", tiempo);
    /**
     * Guia
     */
    Guia guia2 = new Guia("6441663311", "Coahuila", "Cortinas", "663", "Ulises", "Andrade", "Flor", tiempo);
    /**
     * Guia
     */
    Guia guia3 = new Guia("6441856321", "Calle 200", "Alameda", "852", "Jesús", "Beltrán", "Bernal", tiempo);
    /**
     * Guia
     */
    Guia guia4 = new Guia("6442105263", "Flavio Borquez", "Cocorit", "142", "Ernesto", "Uruchurtu", "Meza", tiempo);
    /**
     * Guia
     */
    Guia guia5 = new Guia("6441965412", "Boulevard Ramirez", "Yaqui", "964", "Martin", "Morales", "Rojas", tiempo);
    /**
     * Guia
     */
    Guia guia6 = new Guia("6441369142", "California", "Sahuaripa", "965", "Salvador", "Salazar", "Torres", tiempo);
    /**
     * Habitat
     */
    Habitat habitat1 = new Habitat("Selva", "Tropical", "Bosques densos", Arrays.asList("África", "América", "Europa"));
    /**
     * Habitat
     */
    Habitat habitat2 = new Habitat("Desierto", "Árido", "Plantas secas", Arrays.asList("África"));
    /**
     * Habitat
     */
    Habitat habitat3 = new Habitat("Bosque Templado", "Templado", "Árboles caducifolios", Arrays.asList("Europa", "América", "Asia"));
    /**
     * Habitat
     */
    Habitat habitat4 = new Habitat("Manglar", "Tropical y subtropical", "Árboles y arbustos", Arrays.asList("África", "América", "Asia", "Oceanía"));
    /**
     * Habitat
     */
    Habitat habitat5 = new Habitat("Bosque boreal", "Frío", "Coníferas", Arrays.asList("América", "Europa", "Asia"));
    /**
     * Habitat
     */
    Habitat habitat6 = new Habitat("Pradera", "Templado", "Hierba alta", Arrays.asList("Europa", "Asia"));

    /**
     * Habitat
     */
    Habitat habitat7 = new Habitat("Sabana", "Seco", "Vegetación escasa", Arrays.asList("África"));

    /**
     * Zona
     */
    Zona zona1 = new Zona(800.0f, "Zona A");
    /**
     * Zona
     */
    Zona zona2 = new Zona(900.0f, "Zona B");
    /**
     * Zona
     */
    Zona zona3 = new Zona(400.0f, "Zona C");
    /**
     * Zona
     */
    Zona zona4 = new Zona(700.0f, "Zona D");
    /**
     * Zona
     */
    Zona zona5 = new Zona(500.0f, "Zona E");
    /**
     * Zona
     */
    Zona zona6 = new Zona(600.0f, "Zona F");
    /**
     * Zona
     */
    Zona zona7 = new Zona(300.0f, "Zona G");

    /**
     * Especie
     */
    Especie especie1 = new Especie("Panthera leo", "El león es un felino grande y carnívoro que habita en las áreas de sabana", "León", habitat7.getId(), zona1);
    /**
     * Especie
     */
    Especie especie2 = new Especie("Canis lupus", "El lobo es un mamífero carnívoro que vive en manadas", "Lobo", habitat5.getId(), zona3);
    /**
     * Especie
     */
    Especie especie3 = new Especie("Elephas maximus", "El elefante es el animal terrestre más grande y se caracteriza por su trompa larga y colmillos.", "Elefante", habitat7.getId(), zona1);
    /**
     * Especie
     */
    Especie especie4 = new Especie("Panthera tigris", "El tigre es un felino poderoso y se encuentra en diversos hábitats", "Tigre.", habitat1.getId(), zona1);
    /**
     * Especie
     */
    Especie especie5 = new Especie("Giraffa camelopardalis", "La jirafa es un mamífero herbívoro con un cuello largo y patrones únicos en su pelaje", "Jirafa", habitat7.getId(), zona2);
    /**
     * Especie
     */
    Especie especie6 = new Especie("Ursus arctos", "El oso pardo es un gran mamífero omnívoro que se encuentra en diversas regiones del mundo", "Oso pardo", habitat3.getId(), zona2);
    /**
     * Especie
     */
    Especie especie7 = new Especie("Macaca mulatta", "El macaco de cola larga es una especie de mono que se encuentra en Asia", "Macaco de cola larga", habitat3.getId(), zona2);
    /**
     * Especie
     */
    Especie especie8 = new Especie("Panthera pardus", "El leopardo es un felino ágil y sigiloso que se encuentra en diversas regiones de África y Asia", "Leopardo", habitat1.getId(), zona1);
    /**
     * Especie
     */
    Especie especie9 = new Especie("Gorilla beringei", "El gorila de montaña es un gran primate que habita en las regiones montañosas de África", "Gorila de montaña", habitat6.getId(), zona4);
    /**
     * Especie
     */
    Especie especie10 = new Especie("Vulpes vulpes", "El zorro rojo es un mamífero pequeño y ágil que se encuentra en diversas regiones del mundo", "Zorro rojo", habitat6.getId(), zona4);
    /**
     * Especie
     */
    Especie especie11 = new Especie("Puma concolor", "El puma es un felino ágil y solitario que se encuentra en América", "Puma", habitat1.getId(), zona1);
    /**
     * Especie
     */
    Especie especie12 = new Especie("Macropus rufus", "El canguro rojo es un marsupial saltador que habita en Australia.", "Canguro rojo", habitat4.getId(), zona5);
    /**
     * Especie
     */
    Especie especie13 = new Especie("Myrmecophaga tridactyla", "El oso hormiguero gigante es un mamífero que se alimenta principalmente de hormigas y termitas.", "Oso hormiguero gigante", habitat3.getId(), zona2);
    /**
     * Especie
     */
    Especie especie14 = new Especie("Hylobates lar", "El gibón común es un primate arborícola que habita en selvas tropicales", "Gibón común", habitat3.getId(), zona2);
    /**
     * Especie
     */
    Especie especie15 = new Especie("Panthera onca", "La jaguar es un felino grande y poderoso que se encuentra principalmente en América", "Jaguar", habitat1.getId(), zona1);
    /**
     * Especie
     */
    Especie especie16 = new Especie("Equus ferus caballus", "El caballo doméstico es un mamífero herbívoro que ha sido domesticado por el ser humano", "Caballo", habitat6.getId(), zona4);
    /**
     * Especie
     */
    Especie especie17 = new Especie("Pavo cristatus", "El pavo real es un ave conocida por su plumaje colorido y su característico abanico de plumas", "Pavo real", habitat6.getId(), zona4);
    /**
     * Especie
     */
    Especie especie18 = new Especie("Loxodonta africana", "El elefante africano es el animal terrestre más grande del continente africano", "Elefante africano", habitat2.getId(), zona6);
    /**
     * Especie
     */
    Especie especie19 = new Especie("Panthera uncia", "La pantera de las nieves es un felino que habita en los bosques boreales", "Jaguar", habitat5.getId(), zona3);
    /**
     * Especie
     */
    Especie especie20 = new Especie("Ursus maritimus", "El oso polar es un gran mamífero que se encuentra en las regiones árticas y polares", "Oso polar", habitat5.getId(), zona3);

    /**
     * Verifica que existan, si no existen, los inserta
     *
     * @throws DAOException Si ya fueron insertados
     */
    public void insertarDummies() throws DAOException {
        if (guias.find().into(new ArrayList<>()).isEmpty()
                || zonas.find().into(new ArrayList<>()).isEmpty()
                || habitats.find().into(new ArrayList<>()).isEmpty()
                || especies.find().into(new ArrayList<>()).isEmpty()) {
            guias.insertMany(Arrays.asList(guia1, guia2, guia3, guia4, guia5, guia6));
            zonas.insertMany(Arrays.asList(zona1, zona2, zona3, zona4, zona5, zona6, zona7));
            habitats.insertMany(Arrays.asList(habitat1, habitat2, habitat3, habitat4, habitat5, habitat6, habitat7));

            especie1.setHabitat(habitat1.getId());
            especie2.setHabitat(habitat2.getId());
            especie3.setHabitat(habitat3.getId());
            especie4.setHabitat(habitat4.getId());
            especie5.setHabitat(habitat5.getId());
            especie6.setHabitat(habitat6.getId());
            especie7.setHabitat(habitat7.getId());
            especie8.setHabitat(habitat1.getId());
            especie9.setHabitat(habitat2.getId());
            especie10.setHabitat(habitat3.getId());
            especie11.setHabitat(habitat4.getId());
            especie12.setHabitat(habitat5.getId());
            especie13.setHabitat(habitat6.getId());
            especie14.setHabitat(habitat7.getId());
            especie15.setHabitat(habitat1.getId());
            especie16.setHabitat(habitat2.getId());
            especie17.setHabitat(habitat3.getId());
            especie18.setHabitat(habitat4.getId());
            especie19.setHabitat(habitat5.getId());
            especie20.setHabitat(habitat6.getId());
            especies.insertMany(Arrays.asList(especie1, especie2, especie3,
                    especie4, especie5, especie6, especie7, especie8, especie9,
                    especie10, especie11, especie12, especie13, especie14, especie15,
                    especie16, especie17, especie18, especie19, especie20));

        } else {
            throw new DAOException("Ya fueron insertados los datos");
        }
    }

}
