import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-crear-producto',
  templateUrl: './crear-producto.component.html',
  styleUrls: ['./crear-producto.component.css']
})
export class CrearProductoComponent implements OnInit {

  productoForm: FormGroup;
  titulo = 'Crear producto';
  id: string | null;

  constructor(private fb: FormBuilder, 
              private router: Router,
              private toastr: ToastrService,
              private _productoService: ProductoService,
              private arouter:ActivatedRoute) { 
    this.productoForm = this.fb.group({
      producto: ['', Validators.required],
      categoria: ['', Validators.required],
      descripcion: ['', Validators.required],
      precio: ['', Validators.required],
    })

    this.id = this.arouter.snapshot.paramMap.get('id');

  }
  ngOnInit(): void {
    this.esEditar();
  }

  agregarProducto(){

    const PRODUCTO: Producto = {
      nombre: this.productoForm.get('producto')?.value,
      categoria: this.productoForm.get('categoria')?.value,
      descripcion: this.productoForm.get('descripcion')?.value,
      precio: this.productoForm.get('precio')?.value,
    }

    if(this.id !== null) {
      //se edita el producto
      this._productoService.editarProducto(this.id, PRODUCTO).subscribe(data =>{
        this.toastr.info('El producto fue actualizado con éxito!', 'Producto actualizado'); 
        this.router.navigate(['/']);
      },error => {
        console.log(error);
        this.productoForm.reset();
      })   

    }else {
      //agregamos el producto
      console.log(PRODUCTO);
      this._productoService.guardarProducto(PRODUCTO).subscribe(data => {
        this.toastr.success('El producto fue registrado con éxito!', 'Producto agregado'); 
        this.router.navigate(['/']);
      },error => {
        console.log(error);
        this.productoForm.reset();
      })   
      }    
  }

  esEditar(){
    if(this.id !== null){
      this.titulo = 'Editar producto';
      this._productoService.obtenerProducto(this.id).subscribe(data => {
        this.productoForm.setValue({
          producto: data.nombre,
          categoria: data.categoria,
          descripcion: data.descripcion,
          precio: data.precio,
        })
      })
    }
  }

}
