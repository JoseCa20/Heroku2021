export class Producto{
    id?: number;
    nombre: String;
    categoria: String;
    descripcion: String;
    precio: number;

    constructor(id: number, nombre: String, categoria: String, descripcion: String, precio: number){
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}