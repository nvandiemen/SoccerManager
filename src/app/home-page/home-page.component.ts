import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { PlayersComponent } from '../players/players.component';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

teams: any;  
constructor(public http: HttpClient){
this.teams = [];
  

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

}
