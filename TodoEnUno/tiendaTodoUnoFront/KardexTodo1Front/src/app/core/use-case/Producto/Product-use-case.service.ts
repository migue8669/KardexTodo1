import { Injectable } from '@angular/core';
import { Producto, newProductoData } from 'src/app/core/models/index.model';
import { Observable } from 'rxjs';
import { ProductService } from '../../services/Producto/Product.service';

@Injectable({
  providedIn: 'root'
})
export class ProductUseCaseService {

  constructor(private productService: ProductService) {}

  postProductservice(Producto: newProductoData): Observable<newProductoData> {
    return this.productService.saveNewProduct(Producto);
  }
  getAllProductService(): Observable<Producto[]> {
    return this.productService.getAllProduct();
  }
}
