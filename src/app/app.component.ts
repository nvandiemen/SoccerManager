import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { TeamsComponent } from './teams/teams.component';
import { PlayersComponent } from './players/players.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Online-Soccer-Manager';

  @ViewChild('container', {read: ViewContainerRef})
  container!: ViewContainerRef;

  createComponent(){
    this.container.createComponent(PlayersComponent)
  }
  
 
}
