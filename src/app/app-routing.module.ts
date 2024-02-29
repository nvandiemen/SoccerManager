import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayersComponent } from './players/players.component';
import { TeamsComponent } from './teams/teams.component';
import { HomePageComponent } from './home-page/home-page.component';
import { TeamDetailComponent } from './team-detail/team-detail.component';
import { AddPlayerComponent } from './add-player/add-player.component';
import { PlayerDetailComponent } from './player-detail/player-detail.component';
import { TransfersComponent } from './transfers/transfers.component';




const routes: Routes = [

  { path: 'players', component: PlayersComponent },
  { path: 'teams', component: TeamsComponent},
  // { path: 'teams/team/:team.teamId', component: TeamDetailComponent},  
  { path: 'home', component: HomePageComponent},
  { path: 'teams/teamdetail/:teamNumber', component: TeamDetailComponent},
  { path: 'add-player', component: AddPlayerComponent},
  { path: 'players/playersdetails/:id', component: PlayerDetailComponent},
  { path: 'transfers', component: TransfersComponent}

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
