import { Injectable } from '@angular/core';
import { Producto, newProductoData } from 'src/app/core/models/index.model';
import { Observable } from 'rxjs';
import { BillsService } from '../../services/bills/bills.service';

@Injectable({
  providedIn: 'root'
})
export class BillsUseCaseService {

  constructor(private billsService: BillsService) {}

  postBillervice(Producto: newProductoData): Observable<newProductoData> {
    return this.billsService.saveNewBill(Producto);
  }
  getAllBillsService(): Observable<Producto[]> {
    return this.billsService.getAllbills();
  }
}
