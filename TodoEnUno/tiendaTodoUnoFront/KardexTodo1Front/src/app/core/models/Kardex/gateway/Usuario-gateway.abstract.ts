import { Observable } from "rxjs";
import {Producto, newProductoData,newUsuarioData, Usuario } from "../../index.model";


export abstract class UserAbstract {
  abstract getAllUser(): Observable<Usuario[]>;
  abstract updateUser(id: string, data: newUsuarioData): Observable<newUsuarioData>;
  abstract deleteUserById(id: string): Observable<Usuario>;
  abstract getUserById(id: string): Observable<Usuario>;
  //abstract getBillByName(nameClient: string): Observable<Producto[]>;
  abstract saveNewUser(body: string[]): Observable<newUsuarioData>;
}
