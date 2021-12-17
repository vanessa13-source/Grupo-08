/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.uni.fiis.appventa.dto;

import lombok.Data;

import java.sql.Date;

/**
 *
 * @author Bryan
 * id_transaccion serial,
 * 	monto numeric(9,2),
 * 	fecha timestamp,
 * 	id_tipoTransaccion int,
 * 	id_usuario int,
 * 	primary key (id_transaccion),
 * 	foreign key (id_usuario) references Usuario(id_usuario),
 * 	foreign key (id_tipoTransaccion) references TipoTransaccion(id_tipoTransaccion)
 */
@Data
public class Transaccion {
    private Long id_transaccion;
    private Double monto;
    private Date fecha;
    private Long id_tipoTransaccion;
    private Long id_usuario;
}
