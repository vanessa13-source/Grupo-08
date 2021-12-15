package pe.edu.uni.fiis.appventa.dao;

import pe.edu.uni.fiis.appventa.dto.Transaccion;
import pe.edu.uni.fiis.appventa.dto.Usuario;

public interface AppVentaDao {
    public abstract Usuario autenticar(Usuario usuario);
    public abstract Usuario registrarUsuario(Usuario usuario);
    public abstract Transaccion registrarIngresosExt(Transaccion transaccion);
    public abstract Transaccion registrarEgresosExt(Transaccion transaccion);
}
