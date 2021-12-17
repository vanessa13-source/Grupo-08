import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ApiService} from "../Api Service";
import {Usuario} from "../model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  pagina:string = 'A';
  usuario:Usuario = {
    idUsuario : 0,
    dni : "",
    nombre : "",
    apellido : "",
    email : "",
    contrasena : ""
  };
  contrasena: string = "";
  mensaje: string = "";
  constructor(private apiservice: ApiService, private route: Router) { }

  ngOnInit(): void {
    this.usuario = {
      idUsuario : 0,
      dni : "",
      nombre : "",
      apellido : "",
      email : "",
      contrasena : ""
    };
    this.pagina = 'A';
  }
  cambiarPagina():void{
    if (this.pagina == 'A'){
      this.pagina = 'N';
    }
    else {
      this.pagina = 'A';
    }
  }
  registrarUsuario():void{
    this.apiservice.registrarUsuario(this.usuario).subscribe((data) => {
      console.log(data);
    });
  }
  autenticar(): void{
    this.mensaje = "";
    this.apiservice.autenticar(this.usuario).subscribe((data) => {
      console.log(data);
      if(data.dni != ""){
        this.route.navigateByUrl("menu");
      }
      else{
        this.mensaje = "Contraseña incorrecta";
      }
    });
  }

}
