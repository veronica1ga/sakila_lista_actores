/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ejemplojsfgonzalezv.web.data;

import java.sql.Connection;

/**
 *
 * @author Veronica Gonzalez
 */
public interface ConnectionProvider {
    
    public Connection getConexion();
}

