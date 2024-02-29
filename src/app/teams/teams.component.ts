import { Component, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm, NgModel } from '@angular/forms';




@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent {
  currentTeamNumber: any;
  teams: any;  
  form: any;
  updatedTeam: any;

  
  
  constructor(public http: HttpClient){
  this.teams = [];
  this.form = NgForm;
  this.currentTeamNumber = [];
  this.updatedTeam = [];
 }
  
  ngOnInit(){
    this.showAllTeams();
    
    
  }
  
    showAllTeams(){
    
      this.http.get('http://localhost:8080/teams')
      .subscribe((result)=>{
        this.teams = result;
        
        
      });
  
  }
  
  deleteTeam(teamId: number){
    this.http.delete('http://localhost:8080/teams/' +teamId).subscribe();
    console.log('Team deleted'); 
    
  
  }

  
 
onSubmit(newTeam: {teamName: String}){
  console.log(newTeam);
  this.http.post('http://localhost:8080/teams', newTeam)
  .subscribe((response)=>{
    });

   }

  updateCurrentTeam(teamId: number){
    this.updatedTeam = teamId;
    return this.updatedTeam;

  }


  // @ViewChild('')
  testFunction(){
    console.log("Test succes")
  }

  }



