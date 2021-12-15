package pe.edu.uni.fiis.appventa.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uni.fiis.appventa.dao.AppVentaDao;
import pe.edu.uni.fiis.appventa.dto.Transaccion;
import pe.edu.uni.fiis.appventa.dto.Usuario;

@Service
@Transactional
public class AppVentaServiceImpl implements AppVentaService{
    @Autowired
    private AppVentaDao dao;
    public Usuario autenticar(Usuario usuario){
        return dao.autenticar(usuario);
    }
    public Usuario registrarUsuario(Usuario usuario){
        return dao.registrarUsuario(usuario);
    }
    public Transaccion registrarIngresosExt(Transaccion transaccion){
        return dao.registrarIngresosExt(transaccion);
    }
    public Transaccion registrarEgresosExt(Transaccion transaccion){
        return dao.registrarIngresosExt(transaccion);
    }
}