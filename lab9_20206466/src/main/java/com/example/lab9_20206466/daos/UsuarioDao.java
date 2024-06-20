package com.example.lab9_20206466.daos;
import com.example.lab9_20206466.beans.Usuario;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
public class UsuarioDao {
    public ArrayList<Usuario> listarUsuarios(){

        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab9_h692";
        String username = "root";
        String password = "root";

        String sql = "SELECT u.idusuario, u.nombres,u.apellidos,c.categoria, c.fecha_emision,c.fecha_caducidad,p.nombre_pais " +
                "FROM usuario u JOIN licencia c ON u.licencia_idlicencia=c.idlicencia join pais p on c.pais_idpais=p.idpais where u.rol_idrol=1;";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setTipoLicencia(rs.getString(4));
                Date fechaEmision=rs.getDate(5);
                Date fechaCaducidad=rs.getDate(6);

                //validamos la fecha
                String estadoLicencia="";
                java.util.Date date=new java.util.Date();

                if(fechaCaducidad.before(date)){
                    if(date.before(fechaEmision)){
                        estadoLicencia="Vigente";
                    }else{
                        estadoLicencia="No Vigente";
                    }
                }else{
                    estadoLicencia="No Vigente";
                }
                usuario.setEstadoLicencia(estadoLicencia);
                usuario.setPaisProcedencia(rs.getString(7));

                lista.add(usuario);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public ArrayList<Usuario> cantidadDeVecesCanceladas(){

        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab9_h692";
        String username = "root";
        String password = "root";

        String sql = "SELECT * FROM usuario u join renta_auto r on u.idusuario=r.usuario_idusuario where u.idusuario=1;";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setTipoLicencia(rs.getString(4));
                Date fechaEmision=rs.getDate(5);
                Date fechaCaducidad=rs.getDate(6);

                //validamos la fecha
                String estadoLicencia="";
                java.util.Date date=new java.util.Date();

                if(fechaCaducidad.before(date)){
                    if(date.before(fechaEmision)){
                        estadoLicencia="Vigente";
                    }else{
                        estadoLicencia="No Vigente";
                    }
                }else{
                    estadoLicencia="No Vigente";
                }
                usuario.setEstadoLicencia(estadoLicencia);
                usuario.setPaisProcedencia(rs.getString(7));

                lista.add(usuario);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

}
