import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddModelComponent } from './components/add-model/add-model.component';
import { ModelDetailsComponent } from './components/model-details/model-details.component';
import { ModelsListComponent } from './components/models-list/models-list.component';
import { CrawlerComponent } from './components/crawler/crawler.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ModelFilterComponent } from './components/model-filter/model-filter.component';
import { DomainsListComponent } from './components/domains-list/domains-list.component';
import { AddDomainComponent } from './components/add-domain/add-domain.component';
import { DomainDetailsComponent } from './components/domain-details/domain-details.component';
import { UploadModelsComponent } from './components/upload-models/upload-models.component';

@NgModule({
  declarations: [
    AppComponent,
    AddModelComponent,
    ModelDetailsComponent,
    ModelsListComponent,
    CrawlerComponent,
    ModelFilterComponent,
    DomainsListComponent,
    AddDomainComponent,
    DomainDetailsComponent,
    UploadModelsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FontAwesomeModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
