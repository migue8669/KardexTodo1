import { Observable } from "rxjs";
import {Producto, newProductoData } from "../../index.model";

export abstract class BillsAbstract {
  abstract getAllbills(): Observable<Producto[]>;
  abstract updateBills(id: string, data: newProductoData): Observable<newProductoData>;
  abstract deleteBillsById(id: string): Observable<Producto>;
  abstract getBillById(id: string): Observable<Producto>;
  //abstract getBillByName(nameClient: string): Observable<Producto[]>;
  abstract saveNewBill(body: string[]): Observable<newProductoData>;
}
