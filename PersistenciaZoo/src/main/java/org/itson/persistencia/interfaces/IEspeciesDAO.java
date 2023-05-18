/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.interfaces;

import ObjNegocio.Especie;
import java.util.List;

/**
 * Intefaz de uso de acceso a datos
 *
 * @author kim, marki, elmer, yorx
 */
public interface IEspeciesDAO {

    /**
     * Consulta las especies existentes en la base
     *
     * @return especies encontradas
     */
    public List<Especie> consultar();
}
