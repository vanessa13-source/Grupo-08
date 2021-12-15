package pe.edu.uni.fiis.appventa.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.uni.fiis.appventa.dto.Transaccion;
import pe.edu.uni.fiis.appventa.dto.Usuario;
import pe.edu.uni.fiis.appventa.servicio.AppVentaService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST})
public class AppVentaControlador {
    @Autowired
    private AppVentaService servicio;
    @RequestMapping(
            value = "/autenticar",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody Usuario autenticar(@RequestBody Usuario usuario){
        return servicio.autenticar(usuario);
    }
    @RequestMapping(
            value = "/registrar-usuario",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody Usuario registrarUsuario(@RequestBody Usuario usuario){
        return servicio.registrarUsuario(usuario);
    }
    @RequestMapping(
            value = "/registrar-ingreso-extra",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody Transaccion registrarIngresosExt(@RequestBody Transaccion transaccion){
        return servicio.registrarIngresosExt(transaccion);
    }
    @RequestMapping(
            value = "/registrar-egreso-extra",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody Transaccion registrarEgresosExt(@RequestBody Transaccion transaccion){
        return servicio.registrarEgresosExt(transaccion);
    }
}