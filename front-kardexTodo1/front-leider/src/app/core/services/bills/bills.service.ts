import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, } from "@angular/common/http";
import { Observable } from "rxjs";
import { Producto } from "../../models/bills/entity/producto";
import { newProductoData } from "../../models/bills/entity/newProductoData";
import { catchError, map, tap } from "rxjs/operators";
import { environment } from "src/environments/environment";
import { BillsAbstract } from "../../models/bills/gateway/bills-gateway.abstract";



const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};

@Injectable({
  providedIn: "root"
})
export class BillsService extends BillsAbstract {


  private clientsUrl = `${environment.host}:${environment.port}/producto`;

  constructor(private http: HttpClient) {
    super();
  }



  getAllbills(): Observable<Producto[]> {
    return this.http.get<Producto[]>(`http://localhost:8080/producto/all`);
  }

  // getBillByName(nameClient:string): Observable<Producto[]> {
  //   return this.http.get<Producto[]>(this.clientsUrl);
  // }
  updateBills(id: string, data: newProductoData): Observable<newProductoData> {
    return this.http.put<newProductoData>(`http://localhost:8080/producto/updateByIdProducto/${id}`, JSON.stringify(data));

  }

  deleteBillsById(id: string): Observable<Producto> {
    return this.http.delete<Producto>(`http://localhost:8080/producto/deleteProductoById/${id}`);
  }

  getBillById(id: string): Observable<Producto> {
    return this.http.get<Producto>(`http://localhost:8080/producto/getByIdProducto/${id}`);
  }

  saveNewBill(newProductData): Observable<newProductoData> {
    return this.http.post<newProductoData>(`http://localhost:8080/producto/saveNewProducto`, JSON.stringify(newProductoData));
  }
}
