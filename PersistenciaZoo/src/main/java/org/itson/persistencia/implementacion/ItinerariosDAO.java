/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.implementacion;

import ObjNegocio.*;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;
import org.itson.persistencia.excepciones.DAOException;
import org.itson.persistencia.interfaces.IItinerariosDAO;

/**
 * Acceso a datos de itinerarios
 *
 * @author Elkur
 */
public class ItinerariosDAO extends Conn implements IItinerariosDAO {

    /**
     * Nombre de la coleccion el la base de datos
     */
    private final String COLECCION = "itinerarios";
    /**
     * Coleccion de la base de datos
     */
    private MongoCollection<Itinerario> tilin;

    /**
     * Logger
     */
    private static final Logger LOG = Logger.getLogger(ItinerariosDAO.class.getName());

    /**
     * Constructor que inicializa la conexion con la base y obtiene la conexion
     *
     * @param BASE_DATOS Nombre de la base de datos
     */
    public ItinerariosDAO(String BASE_DATOS) {
        super(BASE_DATOS);
        tilin = getBaseDatos().getCollection(COLECCION, Itinerario.class);
    }

    /**
     * Inserta un itinerario en la base de datos
     *
     * @param iti Itinerario a insertar
     * @return Itinerario insertado
     */
    @Override
    public Itinerario insertar(Itinerario iti) throws DAOException {
        try {
            tilin.insertOne(iti);
            return iti;
        } catch (MongoException e) {
            Logger.getLogger(ItinerariosDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar el itinerario");
        }
    }

    /**
     * Consulta los itinerarios del guia que tengan el mismo id dado en el
     * parametro
     *
     * @param id id del guia
     * @return Itinerarios del
     */
    @Override
    public List<Itinerario> consultar(String id) {
        List<Itinerario> itinerarios = new LinkedList<>();
        itinerarios = tilin.find(Filters.eq("guia", new ObjectId(id))).into(itinerarios);
        return itinerarios;
    }

    /**
     * Consulta la existencia de un itinerario con el mismo nombre que el del
     * parametro
     *
     * @param nombre nombre del itinerario a buscar
     * @return Itinerario encontrado
     */
    @Override
    public Itinerario consultarNombre(String nombre) {
        List<Itinerario> itinerarios = new LinkedList<>();
        itinerarios = tilin.find(Filters.regex("nombre", nombre, "i")).into(itinerarios);
        return !itinerarios.isEmpty() ? itinerarios.get(0) : null;
    }
}
