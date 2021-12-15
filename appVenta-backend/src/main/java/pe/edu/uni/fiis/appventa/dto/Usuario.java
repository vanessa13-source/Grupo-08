package pe.edu.uni.fiis.appventa.dto;

import lombok.Data;

@Data
public class Usuario {
    /*
    id_usuario serial,
	dni varchar(8),
	nombre varchar(100),
	apellido varchar(100),
	email varchar(100),
	contrasena varchar(100),
	primary key (id_usuario)
    */
    private Long idUsuario;
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
}
