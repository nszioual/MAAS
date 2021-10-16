import { Component, OnInit } from '@angular/core';
import { ModelService } from 'src/app/services/model.service';
import { FormControl } from '@angular/forms';
import { saveAs } from 'file-saver';
import { faDownload, faEdit, faPlus, faLayerGroup } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-models-list',
  templateUrl: './models-list.component.html',
  styleUrls: ['./models-list.component.css'],
})
export class ModelsListComponent implements OnInit {
  faDownload = faDownload;
  faEdit = faEdit;
  faPlus = faPlus;
  faLayerGroup = faLayerGroup;

  models: any;
  totalElements: number;
  totalPages: number;
  offset = 0;
  limit = 8;
  isSearching: boolean;
  name = new FormControl('');

  constructor(private modelService: ModelService) {}

  ngOnInit(): void {
    this.retrieveModels();
    this.isSearching = false;
  }

  retrieveModels(): void {
    this.modelService.getAllPageAble(this.offset, this.limit).subscribe(
      (data) => {
        this.models = data.models;
        this.totalElements = data.totalElements;
        this.totalPages = data.totalPages;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  onKeydown($event: KeyboardEvent): void {
    if ($event.key === 'Enter') {
      this.isSearching = this.name.value.length !== 0;
      this.offset = 1;
      this.searchName();
    }
  }

  searchName(): void {
    this.modelService.findByNamePageAble(this.name.value, this.offset, this.limit).subscribe(
      (data) => {
        this.models = data.models;
        this.totalElements = data.totalElements;
        this.totalPages = data.totalPages;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  nextPage(): void {
    if (this.offset < this.totalPages) {
      this.offset += 1;
      if (!this.isSearching) {
        this.retrieveModels();
      } else {
        this.searchName();
      }
    }
  }

  previousPage(): void {
    if (this.offset > 0) {
      this.offset -= 1;
      if (!this.isSearching) {
        this.retrieveModels();
      } else {
        this.searchName();
      }
    }
  }

  download(model): void {
    this.modelService.downloadVersion(model.id).subscribe(
      (data) => {
        console.log(data);
        saveAs(data, `${model.fileName}`);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
