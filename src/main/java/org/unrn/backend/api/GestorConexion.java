package org.unrn.backend.api;

import java.sql.Connection;
import java.sql.SQLException;

public interface GestorConexion {
    Connection getConnection() throws SQLException;

    void getClose() throws SQLException;
}
