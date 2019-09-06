import { Usuario } from "../../models/Kardex/entity/Usuario";
import { newUsuarioData } from "../../models/Kardex/entity/newUsuarioData";
import{UserAbstract}from "../../models/Kardex/gateway/Usuario-gateway.abstract"
import { HttpClient, HttpHeaders, } from "@angular/common/http";
import { Observable } from "rxjs";
import { Injectable } from '@angular/core';
import { environment } from "src/environments/environment";




const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};

@Injectable({
  providedIn: "root"
})
export class UserService extends UserAbstract {


  private clientsUrl = `${environment.host}:${environment.port}/user`;

  constructor(private http: HttpClient) {
    super();
  }



  getAllUser(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`http://localhost:8080/producto/all`);
  }

  // getBillByName(nameClient:string): Observable<Producto[]> {
  //   return this.http.get<Producto[]>(this.clientsUrl);
  // }
  updateUser(id: string, data: newUsuarioData): Observable<newUsuarioData> {
    return this.http.put<newUsuarioData>(`http://localhost:8080/producto/updateByIdProducto/${id}`, JSON.stringify(data));

  }

  deleteUserById(id: string): Observable<Usuario> {
    return this.http.delete<Usuario>(`http://localhost:8080/producto/deleteProductoById/${id}`);
  }

  getUserById(id: string): Observable<Usuario> {
    return this.http.get<Usuario>(`http://localhost:8080/producto/getByIdProducto/${id}`);
  }

  saveNewUser(newProductData): Observable<newUsuarioData> {
    return this.http.post<newUsuarioData>(`http://localhost:8080/producto/saveNewProducto`, JSON.stringify(newUsuarioData));
  }
}
