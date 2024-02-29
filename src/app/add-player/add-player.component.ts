import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
//import { FileHandle } from '../file-handler';
//import { DomSanitizer } from '@angular/platform-browser';
////import { Player } from '../players/playerModel';


@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']

})
export class AddPlayerComponent {

  loadedTeams: any;
  states = ["Attack", "Midfield", "Defence", "Goalkeeper"];
  selectedLine: String;
  // player: Player = {
  //   playerId: 0,
  //   playerLastName: "",
  //   playerLine: "",
  //   playerPosition: "",
  //   attackScore: 0,
  //   defenseScore: 0,
  //   avarageScore: 0,
  //   teamNumber: 0,
  //   transferValue: 0,
  //   playerImages: []
  // }
  
  

  constructor( public http: HttpClient ){
    this.loadedTeams = [];
    this.selectedLine = "";
    
  }

  ngOnInit(){
    this.loadAllTeams();
    
    }

  onSubmit(newPlayer:{lastName: String, line: String, position: String, attackScore: number, defenseScore: number, averageScore: number, teamNumber: number, teamName: String })
    {
    
    this.http.post('http://localhost:8080/players', newPlayer).
    subscribe((response)=> 

    console.log(newPlayer) 
    
  )};


//   onSubmit(Player: FormData){
//     console.log(this.player);
//     const playerFormData = this.prepareFormData(this.player)
//     this.http.post('http://localhost:8080/players', this.player).
//     subscribe((response)=> 

//     console.log(playerFormData)
    
    
//   )
// };

//   prepareFormData(player: Player): FormData  {
// const formData = new FormData();

// formData.append(
//   'player',
//   new Blob([JSON.stringify(this.player)], {type: 'application/json'})
// );

// for(var i = 0; i< player.playerImages.length; i++){
// formData.append(
//   'player_images',
//   player.playerImages[i].file,
//   player.playerImages[i].file.name

// );
//    }
//    return formData;
//   }

  loadAllTeams(){
    
    this.http.get('http://localhost:8080/teams')
    .subscribe((result)=>{
      this.loadedTeams = result;
      
      
    });


}

setState(){
  if(this.selectedLine == "Attack"){
    this.states = ["ST", "RVA", "LVA"];
  }
  if(this.selectedLine == "Midfield"){
    this.states = ["CAM", "CM", "CVM"];
  }
  if(this.selectedLine == "Defence"){
    this.states = ["CV", "LB", "RB"];
  }
  if(this.selectedLine == "Goalkeeper"){
    this.states = ["GK"];
  }
}


// onFileSelected(event:any){
// console.log(event);
// if(event.target.files){
// const file = event.target.files[0];

// const fileHandle: FileHandle = {
//   file: file,
//   url: this.sanitizer.bypassSecurityTrustUrl(
//     window.URL.createObjectURL(file)
//   )
// }

// this.player.playerImages.push(fileHandle);
// console.log("Image changed")
// }

// }

}
