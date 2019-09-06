import { Observable } from "rxjs";
import {Producto, newProductoData } from "../../index.model";

export abstract class ProductAbstract {
  abstract getAllProduct(): Observable<Producto[]>;
  abstract updateProduct(id: string, data: newProductoData): Observable<newProductoData>;
  abstract deleteProductById(id: string): Observable<Producto>;
  abstract getProductById(id: string): Observable<Producto>;
  //abstract getBillByName(nameClient: string): Observable<Producto[]>;
  abstract saveNewProduct(body: string[]): Observable<newProductoData>;
}
