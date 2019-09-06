import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import {
 ProductService,
 UserService
} from "../service/index.service";

//import { AuthenticationAbstract } from "../../core/models/login/gateway/autentication-gateway.abstract";
import { ProductAbstract } from "../../core/models/Kardex/gateway/Producto-gateway.abstract";
import { UserAbstract } from "../../core/models/Kardex/gateway/Usuario-gateway.abstract";



@NgModule({
  declarations: [],
  imports: [CommonModule],
  providers: [
    //{ provide: AuthenticationAbstract, useClass: LoginService },
   // { provide: BillsAbstract, useClass: BillsService },
  ]
})
export class ServiceModule {}
