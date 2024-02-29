import { HttpClient, HttpEventType, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute, Data } from '@angular/router';

@Component({
  selector: 'app-player-detail',
  templateUrl: './player-detail.component.html',
  styleUrls: ['./player-detail.component.css']
})

export class PlayerDetailComponent {
player: any;
playerDetails: any;
playerTransfers: any;
transfer: any;
event: any;
fileName = '';
file: File | null = null;
private options = { headers: new HttpHeaders().set('Content-Type', 'multipart/form-data') };
currentPlayer: any;



// selectedFile: File | undefined;


  constructor(public http: HttpClient, private activatedRoute: ActivatedRoute){
  this.playerDetails = [];
  this.playerTransfers = [];


  
  }


  ngOnInit(){
    this.showPlayerDetails();
    this.showTransfersByPlayer();

    
    
    }
    
   
    
    showPlayerDetails(){
    this.player = this.activatedRoute.snapshot.paramMap.get('id');
    this.http.get('http://localhost:8080/players/' + this.player)
    .subscribe((result)=>{
      this.playerDetails = result});
      
    }  

  



    onFileChange(event: any) {
    console.log(event);
    const file: File = event.target.files[0];
    this.file = file;

       console.log(file);
       console.log("File has changed");
    }

    showTransfersByPlayer(){
      this.player = this.activatedRoute.snapshot.paramMap.get('id');
      this.http.get('http://localhost:8080/transfers/player/' + this.player)
      .subscribe((result)=>{
        this.playerTransfers = result});
        //console.log(this.playerTransfers);
    }
    

  //   onUpload(){
  //     if (this.file) {
    
  //  console.log("This is: " + this.file.lastModified);
  //  const image = this.file;
  //  //const formData = new FormData();


  //   // formData.append("name", this.file.name);
  //   // formData.append("file", this.file);
  
  //     this.http.put('http://localhost:8080/images', image, this.options).subscribe(res => {
  //     console.log("Test " + res);
  //     }
  //     );

  
         
  // console.log("Upload logged");
  // console.log(image);
 
 
  


 
  //      }
  //     }
       //)
     

}
//}}
