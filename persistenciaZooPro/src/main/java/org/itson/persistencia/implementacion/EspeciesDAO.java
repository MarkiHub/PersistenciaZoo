/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.implementacion;

import ObjNegocio.Especie;
import com.mongodb.client.MongoCollection;
import java.util.LinkedList;
import java.util.List;
import org.itson.persistencia.interfaces.IEspeciesDAO;

/**
 * Acceso a datos de especies
 * @author Elkur
 */
public class EspeciesDAO extends Conn implements IEspeciesDAO {

    private final String COLECCION = "especies";
    private final MongoCollection<Especie> tilin;

    /**
     * Constructor que inicializa la conexion con la base de datos
     *
     * @param BASE_DATOS
     */
    public EspeciesDAO(String BASE_DATOS) {
        super(BASE_DATOS);
        tilin = getBaseDatos().getCollection(COLECCION, Especie.class);
    }

    /**
     * Consulta las especies existentes en la base
     *
     * @return especies encontradas
     */
    @Override
    public List<Especie> consultar() {
        List<Especie> especies = new LinkedList<>();
        especies = tilin.find().into(especies);
        return especies;
    }
}
