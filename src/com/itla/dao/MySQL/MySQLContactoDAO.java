package com.itla.dao.MySQL;

import com.itla.dao.ContactoDAO;
import com.itla.modelo.Contacto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLContactoDAO implements ContactoDAO {

    final String INSERT = "INSERT INTO contactos(nombre, apellidos, empresa, telefono, correo)"
            + "VALUES(?, ?, ?, ?, ?)";

    final String UPDATE = "UPDATE contactos "
            + "SET nombre = ?, apellidos = ?, empresa = ?, telefono = ?, correo = ? "
            + "WHERE id_contacto = ?";

    final String DELETE = "DELETE FROM contactos WHERE id_contacto = ?";

    final String SELECCIONARTODO = "SELECT id_contacto, nombre, apellidos, empresa, telefono, correo"
            + " FROM contactos";

    final String SELECCIONARUNO = "SELECT id_contacto, nombre, apellidos, empresa, telefono, correo"
            + " FROM contactos"
            + " WHERE id_contacto = ?";

    private Connection conn;

    public MySQLContactoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void Insertar(Contacto con) {
        try {
            PreparedStatement pstmnt;
            pstmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            try (pstmnt) {

                pstmnt.setString(1, con.getNombre());
                pstmnt.setString(2, con.getApellidos());
                pstmnt.setString(3, con.getEmpresa());
                pstmnt.setString(4, con.getTelefono());
                pstmnt.setString(5, con.getCorreo());

                pstmnt.execute();

                final ResultSet rs = pstmnt.getGeneratedKeys();

                try (rs) {
                    while (rs.next()) {
                        con.setIdContacto(rs.getLong(1));
                        System.out.println(String.format("Fue insertado el contacto: %s", con));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void Modificar(Contacto con) {
    }

    @Override
    public void Eliminar(Contacto con) {
    }

    @Override
    public List<Contacto> ObtenerTodosContactos() {
        List<Contacto> resultado = new ArrayList<>();

        try {
            final PreparedStatement pstmnt = conn.prepareStatement(SELECCIONARTODO);

            try (pstmnt) {
                pstmnt.execute();

                final ResultSet rs = pstmnt.getResultSet();

                try (rs) {
                    while (rs.next()) {
                        resultado.add(new Contacto(
                                rs.getLong("id_contacto"),
                                rs.getString("nombre"),
                                rs.getString("apellidos"),
                                rs.getString("empresa"),
                                rs.getString("telefono"),
                                rs.getString("correo")));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Contacto Obtener(Long id) {
        try {
            final PreparedStatement pstmnt = conn.prepareStatement(SELECCIONARUNO);

            try (pstmnt) {
                pstmnt.setLong(1, id);
                pstmnt.execute();

                final ResultSet rs = pstmnt.getResultSet();

                try (rs) {
                    if (rs.next()) {
                        return new Contacto(
                                rs.getLong("id_contacto"),
                                rs.getString("nombre"),
                                rs.getString("apellidos"),
                                rs.getString("empresa"),
                                rs.getString("telefono"),
                                rs.getString("correo")
                        );
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
