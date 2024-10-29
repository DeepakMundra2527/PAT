import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CreatePostComponent } from './create-post/create-post.component';

const routes: Routes = [
  {path:"dashboard", component: DashboardComponent},
  {path:"post", component: CreatePostComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
