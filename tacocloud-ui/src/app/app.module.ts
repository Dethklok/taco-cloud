import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BigButtonComponent } from './big-button/big-button.component';
import { CartComponent } from './cart/cart.component';
import { FormsModule } from '@angular/forms';
import { CloudTitleComponent } from './cloud-title/cloud-title.component';
import { DesignComponent } from './design/design.component';
import { FooterComponent } from './footer/footer.component';
import { GroupBoxComponent } from './group-box/group-box.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LittleButtonComponent } from './little-button/little-button.component';
import { LocationsComponent } from './locations/locations.component';
import { LoginComponent } from './login/login.component';
import { RecentsComponent } from './recents/recents.component';
import { NonWrapsPipe } from './recents/NonWrapsPipe';
import { WrapsPipe } from './recents/WrapsPipe';
import { SpecialsComponent } from './specials/specials.component';
import { ApiService } from './api/ApiService';
import { CartService } from './cart/cart-service';
import { RecentTacosService } from './recents/RecentTacosService';

@NgModule({
  declarations: [
    AppComponent,
    BigButtonComponent,
    CartComponent,
    CloudTitleComponent,
    DesignComponent,
    FooterComponent,
    GroupBoxComponent,
    HeaderComponent,
    HomeComponent,
    LittleButtonComponent,
    LocationsComponent,
    LoginComponent,
    NonWrapsPipe,
    RecentsComponent,
    WrapsPipe,
    SpecialsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [
    ApiService,
    CartService,
    RecentTacosService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
