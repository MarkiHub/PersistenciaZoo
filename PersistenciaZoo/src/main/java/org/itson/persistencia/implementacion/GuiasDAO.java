/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.implementacion;

import ObjNegocio.Especie;
import ObjNegocio.Guia;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.client.MongoCollection;
import java.util.LinkedList;
import java.util.List;
import org.itson.persistencia.excepciones.DAOException;
import org.itson.persistencia.interfaces.IGuiasDAO;

/**
 * Clase de acceso a datos de guias
 *
 * @author Elkur
 */
public class GuiasDAO extends Conn implements IGuiasDAO {

    /**
     * Nombre de la coleccion en la base de datos
     */
    private final String COLECCION = "guias";

    /**
     * Coleccion de guias
     */
    private MongoCollection<Guia> guias;

    /**
     * Constructor que recibe el nombre dela base de datos a emplear y consigue
     * la coleccion de los guias
     *
     * @param BASE_DATOS Nombre de la base de datos
     * @throws DAOException Si no se puede establecer la conexion con la base de
     * datos
     */
    public GuiasDAO(String BASE_DATOS) throws DAOException {
        super(BASE_DATOS);
        try {
            guias = getBaseDatos().getCollection(COLECCION, Guia.class);
        } catch (MongoSocketOpenException e) {
            throw new DAOException("Error al intentar acceder a la base de datos");
        }
    }

    /**
     * Consulta todos los guias que estan almacenados en la base de datos
     *
     * @return Lista de guias
     */
    @Override
    public List<Guia> consultar() {
        List<Guia> listaGuias = new LinkedList<>();
        listaGuias = guias.find().into(listaGuias);
        return listaGuias;
    }

}
