import { Producto } from "../../models/Kardex/entity/Producto";
import { newProductoData } from "../../models/Kardex/entity/newProductoData";
import{ProductAbstract}from "../../models/Kardex/gateway/Producto-gateway.abstract"
import { HttpClient, HttpHeaders, } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { environment } from "src/environments/environment";
import { Observable } from "rxjs";




const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};

@Injectable({
  providedIn: "root"
})
export class ProductService extends ProductAbstract {


  private clientsUrl = `${environment.host}:${environment.port}/producto`;

  constructor(private http: HttpClient) {
    super();
  }



  getAllProduct(): Observable<Producto[]> {
    return this.http.get<Producto[]>(`http://localhost:8080/producto/all`);
  }

  // getBillByName(nameClient:string): Observable<Producto[]> {
  //   return this.http.get<Producto[]>(this.clientsUrl);
  // }
  updateProduct(id: string, data: newProductoData): Observable<newProductoData> {
    return this.http.put<newProductoData>(`http://localhost:8080/producto/updateByIdProducto/${id}`, JSON.stringify(data));

  }

  deleteProductById(id: string): Observable<Producto> {
    return this.http.delete<Producto>(`http://localhost:8080/producto/deleteProductoById/${id}`);
  }

  getProductById(id: string): Observable<Producto> {
    return this.http.get<Producto>(`http://localhost:8080/producto/getByIdProducto/${id}`);
  }

  saveNewProduct(newProductData): Observable<newProductoData> {
    return this.http.post<newProductoData>(`http://localhost:8080/producto/saveNewProducto`, JSON.stringify(newProductoData));
  }
}
