import { Component, OnInit } from '@angular/core';
import { ShippingService } from '../shipping.service';
import { HttpClient} from '@angular/common/http';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { RouterModule, Routes, Router } from '@angular/router';



@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})



export class ShowComponent implements OnInit {

  dataColumns: string[] = [ 'id','date', 'shipper' , 'receiver' , 'address' , 'agency' , 'postcode', 'trackingNo' , 'shippingstatus','update'];

  displayedColumns: string[] = [ 'No','date', 'agency','trackingNo', 'shippingstatus'];

  shippingInfo: Array<any>;
  shippingstatuses: Array<any>;

  getstatus: any = {
    shippingID:'',
  }
  
  constructor(private sanitizer: DomSanitizer,private shippingService:ShippingService, private httpClient: HttpClient, private router:Router) { 
    this.sanitizer = sanitizer;
  }

  ngOnInit() {

    this.shippingService.getShippingInfo().subscribe(data => {
      this.shippingInfo = data;
      console.log(this.shippingInfo);
    });

    this.shippingService.getShippingStatus().subscribe(data =>{
      this.shippingstatuses = data;
      console.log(this.shippingstatuses);
    })

  }

  save(shippingID){
    this.httpClient.put('http://localhost:8080/updateShipping/'+ shippingID +'/2',this.getstatus)
      .subscribe(
          data => {
              alert('อัพเดทสำเร็จ');
              console.log('PUT Request is successful', data);
              window.location.reload();
              // this.router.navigate(['show-shipping'])
          },
          error => {
              alert('อัพเดทไม่สำเร็จ');
              console.log('Error', error);
              window.location.reload();
              // this.router.navigate(['show-shipping'])
          }
      );


  }

}
