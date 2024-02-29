import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { TeamsComponent } from '../teams/teams.component';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-team-detail',
  //template: '<app-teams #teams></app-teams>',
  templateUrl: './team-detail.component.html',
  styleUrls: ['./team-detail.component.css']
})
export class TeamDetailComponent {
playersByTeam: any;
team: any;
allTeams: any;



constructor(public http: HttpClient, private activatedRoute: ActivatedRoute){
  this.playersByTeam = [];
  this.allTeams = [];
}




ngOnInit(){
this.showAllPlayersByTeam();

}


showAllPlayersByTeam(){
this.team = this.activatedRoute.snapshot.paramMap.get('teamNumber');
this.http.get('http://localhost:8080/players/team/' + this.team)
.subscribe((result)=>{
  this.playersByTeam = result});
}  

testFunction(){
  console.log("Test worked")
}

}
