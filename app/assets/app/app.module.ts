import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { ModelwynRoutes } from './modelwyn.routes';

import { ModelwynComponent } from './modelwyn.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    ModelwynRoutes,
    HttpModule
  ],
  declarations: [
    HomeComponent,
    ModelwynComponent
  ],
  providers: [],
  bootstrap: [ModelwynComponent]
})
export class AppModule { }

