
import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import {FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms'
import { BillsComponent } from '../bills.component';
import { BillsService } from '../../../core/services/bills/bills.service';
import {Producto} from 'src/app/core/models/bills/entity/producto';
import { Subscription } from 'rxjs';
import { newProductoData } from 'src/app/core/models/bills/entity/newProductoData';
//import { NzNotificationService } from 'ng-zorro-antd/notification';

@Component({
  selector: 'app-add-bill',
  templateUrl: './add-bill.component.html',
  styleUrls: ['./add-bill.component.css']

})
export class AddBillComponent implements OnInit {
  visible = false;
  formulario: FormGroup;
  private validate:boolean=true;
  saveNewBillsApiSub: Subscription;
  AllBill: newProductoData;
  private mensaje:string='';

  constructor(private builder: FormBuilder, private bill: BillsComponent, private api: BillsService, private modalService: NzModalService) {
    this.formulario = this.builder.group({
      producto: new FormControl("",[Validators.required, Validators.minLength(2)]),
      talla: new FormControl("",[Validators.required, Validators.minLength(5)]),
      precio: new FormControl("",[Validators.required, Validators.minLength(5)]),
      genero:  new FormControl("",[Validators.required, Validators.minLength(5)]),

    });
  }



  enviar(AllBill:newProductoData) {
    console.log("ingresa al metodo enviar");
    if(this.formulario.valid){


      console.log("ingresa al if");


  this.saveNewBillsApiSub = this.api.saveNewBill(AllBill).subscribe(
    AllBill => {this.AllBill = AllBill;
                this.bill.getAllbillsApi() });

}
else {

 this.modalService.confirm({
      nzTitle: '',
      nzContent: '<b style="color:orange;">Diligencia el formulario completo por favor</b>',
      nzOkText: 'Yes',
      nzOkType: 'danger',

      nzCancelText: 'No',
      nzOnCancel: () => console.log('Cancel')
    });
    this.bill.open();
}
}
  close(): void {
    this.visible = false;
    this.bill.close()
  }

  ngOnInit() {
  }

}


// import { Component, OnInit } from '@angular/core';
// import { NzModalService } from 'ng-zorro-antd';
// import {FormBuilder, FormGroup } from '@angular/forms'
// import { BillsComponent } from '../bills.component';
// import { BillsService } from '../../../core/services/bills/bills.service';
// import {Bills} from 'src/app/core/models/bills/entity/Bills';
// import { Subscription } from 'rxjs';
// import { newBillData } from 'src/app/core/models/bills/entity/newBillData';

// @Component({
//   selector: 'app-add-bill',
//   templateUrl: './add-bill.component.html',
//   styleUrls: ['./add-bill.component.css']
// })
// export class AddBillComponent implements OnInit {
//   visible = false;
//   formulario: FormGroup;
//   saveNewBillsApiSub: Subscription;
//   AllBill: newBillData;

//   constructor(private builder: FormBuilder, private bill: BillsComponent, private api: BillsService) {
//     this.formulario = this.builder.group({
//       name: [""],
//       companyL: [""],
//       telephone: [""],
//       address: [""],
//       city: [""],
//       currency: [""],
//       description: [""],
//       amountHoursWorkedS: [""],
//       discountProduct: [""],
//       total: [""],
//     })
//   }

//   enviar(bill:newBillData) {
//     this.saveNewBillsApiSub = this.api.saveNewBill(bill).subscribe(
//       AllBill => {this.AllBill = AllBill;
//                   this.bill.getAllbillsApi() });
//   }

//   close(): void {
//     this.visible = false;
//     this.bill.close()
//   }

//   ngOnInit() {
//   }

// }
