import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-transfers',
  templateUrl: './transfers.component.html',
  styleUrls: ['./transfers.component.css']
})
export class TransfersComponent {
player: any;
players: any;
teams: any;
teamNumber: any;
dto: any;
playerToUpdate: any;




  constructor(public http: HttpClient){
    this.players = [];
    this.teams = [];
  }


  ngOnInit(){
this.getAllPlayersAndTeams()
    
    }



  onSubmit(dto:{playerId: number, newTeamId: number, oldTeamId: number, value: number}){
  this.teamNumber = dto.newTeamId;
   

  this.http.post('http://localhost:8080/transfers', dto).
  subscribe((response)=> 
  //Bovenstaande als uitwisselings opslaan als een ID van een transfer, maar hieronder nog een update API maken voor wisseling van Team
  console.log("This is the dto 1: " + dto))

  //this.updateTeam(dto)
}


updateTeam(playerToUpdate:{id: number, teamNumber: number}){
console.log("Test: this is DTO = " + playerToUpdate)
console.log("Test: this is DTO. newTeam " + playerToUpdate)

// let playerToUpdateId = dto.playerId;
// let playerToUpdateNewTeam = dto.newTeamId;
// let id: any;
// let teamNumber: any;

//  let playerToUpdate = {
//  id : playerToUpdateId,
//  teamNumber : playerToUpdateNewTeam
// }

console.log("Test player to update: " + playerToUpdate.teamNumber);

this.http.patch('http://localhost:8080/players/' + playerToUpdate.id, playerToUpdate ).subscribe((response)=>

console.log("This is player to update: " + playerToUpdate.id + " and teamNumber: " + playerToUpdate.teamNumber)

)
}


getAllPlayersAndTeams(){
this.http.get('http://localhost:8080/players').
subscribe((result)=>
this.players = result)

this.http.get('http://localhost:8080/teams').
subscribe((result)=>
this.teams = result)
}



}






