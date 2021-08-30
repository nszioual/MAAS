import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ModelsListComponent } from './components/models-list/models-list.component';
import { ModelDetailsComponent } from './components/model-details/model-details.component';
import { AddModelComponent } from './components/add-model/add-model.component';
import { DomainsListComponent } from './components/domains-list/domains-list.component';
import { DomainDetailsComponent } from './components/domain-details/domain-details.component';
import { AddDomainComponent } from './components/add-domain/add-domain.component';
import { CrawlerComponent } from './components/crawler/crawler.component';
import { ModelFilterComponent } from './components/model-filter/model-filter.component';
import { UploadModelsComponent } from './components/upload-models/upload-models.component';

const routes: Routes = [
  { path: '', redirectTo: 'models', pathMatch: 'full' },
  { path: 'models', component: ModelsListComponent },
  { path: 'models/get/:id', component: ModelDetailsComponent },
  { path: 'models/add', component: AddModelComponent },
  { path: 'domains', component: DomainsListComponent },
  { path: 'domains/get/:id', component: DomainDetailsComponent },
  { path: 'domains/add', component: AddDomainComponent },
  { path: 'crawler', component: CrawlerComponent },
  { path: 'filter', component: ModelFilterComponent },
  { path: 'upload', component: UploadModelsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
