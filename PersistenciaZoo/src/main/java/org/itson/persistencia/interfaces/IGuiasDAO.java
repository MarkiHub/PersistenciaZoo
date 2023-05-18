/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.interfaces;

import ObjNegocio.Guia;
import java.util.List;

/**
 * Interfaz de uso de acceso a datos de guias
 *
 * @author kim, marki, elmer, yorx
 */
public interface IGuiasDAO {

    /**
     * Consulta todos los guias de la base de datos
     *
     * @return Lista de guias
     */
    public List<Guia> consultar();
}
