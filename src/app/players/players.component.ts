import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent {
players: any;
form: any;
defenders: any;
midfielders: any;
attackers: any;
goalkeepers: any;

constructor(public http: HttpClient){
this.players = [];
this.form = NgForm;
this.defenders = [];
this.midfielders = [];
this.attackers = [];
this.goalkeepers = [];
}

ngOnInit(){
  // nog samen te voegen naar 1 onInit functie
  this.showAllPlayers();
  this.showAllDefenders();
  this.showAllMidfielders();
  this.showAllAttackers();
  this.showAllGoalkeepers();

}

showAllPlayers(){
this.http.get('http://localhost:8080/players')
.subscribe((result)=>{
  this.players = result});
 
}

showAllDefenders(){
this.http.get('http://localhost:8080/players/defence')
.subscribe((result)=>{
this.defenders = result});
}

showAllMidfielders(){
  this.http.get('http://localhost:8080/players/midfield')
  .subscribe((result)=>{
    this.midfielders = result});
  }

showAllAttackers(){
  this.http.get('http://localhost:8080/players/attack')
  .subscribe((result) =>{
    this.attackers = result});
  
}

showAllGoalkeepers(){
  this.http.get('http://localhost:8080/players/goalkeeper').subscribe((result)=>{
    this.goalkeepers = result});
  
}



}


