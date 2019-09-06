import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { CommonModule } from "@angular/common";
import {
  BillsComponent,
 // LoginComponent,
} from "../pages";

@NgModule({
  declarations: [
    KardexComponent,
  //  LoginComponent
  ],
  imports: [CommonModule],
  exports: [
    KardexComponent,
      //  LoginComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ModuleModule {}
