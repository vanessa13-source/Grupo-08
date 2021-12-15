package pe.edu.uni.fiis.appventa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.edu.uni.fiis.appventa.dto.Transaccion;
import pe.edu.uni.fiis.appventa.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AppVentaDaoImpl implements AppVentaDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Usuario autenticar(Usuario usuario){
        String SQL="SELECT dni,nombre,apellido,email,contrasena FROM Usuario WHERE dni = ? AND contrasena = ?";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,usuario.getDni());
            ps.setString(2,usuario.getContrasena());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                usuario = new Usuario();
                usuario.setDni(rs.getString("dni"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usuario;
    }
    public Usuario registrarUsuario(Usuario usuario){
        String SQL="INSERT INTO Usuario(dni,nombre,apellido,email,contrasena)" +
                " VALUES (?,?,?,?,?)";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,usuario.getDni());
            ps.setString(2,usuario.getNombre());
            ps.setString(3,usuario.getApellido());
            ps.setString(4,usuario.getEmail());
            ps.setString(5,usuario.getContrasena());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return usuario;
    }
    public Transaccion registrarIngresosExt(Transaccion transaccion){
        String SQL="Insert into Transaccion(monto,fecha,id_tipoTransaccion,id_usuario)" +
                "values (?,?,?,?)";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1,transaccion.getMonto());
            ps.setDate(2,transaccion.getFecha());
            ps.setLong(3,transaccion.getId_tipoTransaccion());
            ps.setLong(4,transaccion.getId_usuario());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return transaccion;
    }
    public Transaccion registrarEgresosExt(Transaccion transaccion){
        String SQL="Insert into Transaccion(monto,fecha,id_tipoTransaccion,id_usuario)" +
                "values (?,?,?,?)";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1,transaccion.getMonto());
            ps.setDate(2,transaccion.getFecha());
            ps.setLong(3,transaccion.getId_tipoTransaccion());
            ps.setLong(4,transaccion.getId_usuario());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return transaccion;
    }
}
