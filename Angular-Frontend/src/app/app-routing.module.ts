import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ListarProductosComponent } from './components/listar-productos/listar-productos.component';
import { CrearProductoComponent } from './components/crear-producto/crear-producto.component';
import { RegistroComponent } from './auth/registro.component';
import { LoginComponent } from './auth/login.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'registro', component: RegistroComponent},  
  { path: '', component: ListarProductosComponent },
  { path: 'crear-producto', component: CrearProductoComponent },
  { path: 'editar-producto/:id', component: CrearProductoComponent },
  { path:'**', redirectTo: '', pathMatch: 'full' }
]



@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),  
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
