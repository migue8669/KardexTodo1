import { Component, OnInit, Input } from '@angular/core';
import { BillsService } from '../../../core/services/bills/bills.service';
//import { newBillData } from 'src/app/core/models/bills/entity/newProductData';
import { NzModalService } from 'ng-zorro-antd';
//import{newProductoData}from '../../../core/services/bills/bills.service';
import { newProductoData } from 'src/app/core/models/index.model';
//import { newProductoData } from 'src/app/core/models/index.model';
@Component({
  selector: 'app-edit-bill',
  templateUrl: './edit-bill.component.html',
  styleUrls: ['./edit-bill.component.css']
})
export class EditBillComponent implements OnInit {
  respuesta: newProductoData;
  isVisible = false;
  bill: any = {};
  newBillData: newProductoData = this.bill;
  @Input() data: any;
  modalService: any;

  constructor( private api: BillsService ) { }

  updateBillIdApi(id, BillData): void{
    this.api.updateBills(id, BillData).subscribe(
      respuesta => {
        this.respuesta = respuesta;
        this.api.getAllbills();
      });
  }
  getAllbillIdApi(bill): void{
    this.api.getBillById(bill).subscribe(
      allBill => {
        this.bill = allBill;
      });
 }
 UpdateOk(value){

  console.log(value);
  this.parseBillDada();
  this.updateBillIdApi(value.id, this.newBillData);
}

  parseBillDada(){
    console.log("adentroParseB");
  //  if(this.newBillData.idBill==null){
      console.log("adentro del if");

      this.bill.open();
if(this.newBillData.id=null){this.modalService.confirm({

  nzTitle: '',
  nzContent: '<b style="color:orange;">Diligencia el formulario completo por favor</b>',
  nzOkText: 'Yes',
  nzOkType: 'danger',

  nzCancelText: 'No',
  nzOnCancel: () => console.log('Cancel')
});}else{
    this.newBillData.id = this.data.id;}
    if(this.newBillData.producto=null){this.modalService.confirm({

      nzTitle: '',
      nzContent: '<b style="color:orange;">Diligencia el formulario completo por favor</b>',
      nzOkText: 'Yes',
      nzOkType: 'danger',

      nzCancelText: 'No',
      nzOnCancel: () => console.log('Cancel')
    });}else{
        this.newBillData.producto = this.data.producto;}
        this.newBillData.talla = this.data.talla;
          // if(this.newBillData.talla=null){this.modalService.confirm({

          //   nzTitle: '',
          //   nzContent: '<b style="color:orange;">Diligencia el formulario completo por favor</b>',
          //   nzOkText: 'Yes',
          //   nzOkType: 'danger',

          //   nzCancelText: 'No',
          //   nzOnCancel: () => console.log('Cancel')
          // });}else{

            // if(this.newBillData.telephone=null){this.modalService.confirm({

            //   nzTitle: '',
            //   nzContent: '<b style="color:orange;">Diligencia el formulario completo por favor</b>',
            //   nzOkText: 'Yes',
            //   nzOkType: 'danger',

            //   nzCancelText: 'No',
            //   nzOnCancel: () => console.log('Cancel')
            // });}else{
                this.newBillData.genero = this.data.genero;
                // if(this.newBillData.address=null){this.modalService.confirm({

                //   nzTitle: '',
                //   nzContent: '<b style="color:orange;">Diligencia el formulario completo por favor</b>',
                //   nzOkText: 'Yes',
                //   nzOkType: 'danger',

                //   nzCancelText: 'No',
                //   nzOnCancel: () => console.log('Cancel')
                // });}else{
                    this.newBillData.precio = this.data.precio;

    console.log(this.newBillData);
  }
  handleOk() {
    this.isVisible = false;
    this.parseBillDada()
    this.updateBillIdApi(this.bill.id, this.newBillData);
  }

  ngOnInit() {

  }

}
