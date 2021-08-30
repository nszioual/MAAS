import { Component, OnInit } from '@angular/core';
import { ModelService } from 'src/app/services/model.service';
import { FormControl } from '@angular/forms';
import { saveAs } from 'file-saver';
import { faDownload, faEdit, faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-models-list',
  templateUrl: './models-list.component.html',
  styleUrls: ['./models-list.component.css'],
})
export class ModelsListComponent implements OnInit {
  faDownload = faDownload;
  faEdit = faEdit;
  faPlus = faPlus;

  models: any;
  totalElements: number;
  totalPages: number;
  currentPage = 0;
  isSearching: boolean;
  name = new FormControl('');

  constructor(private modelService: ModelService) {}

  ngOnInit(): void {
    this.retrieveModels();
    this.isSearching = false;
  }

  retrieveModels(): void {
    this.modelService.getAllPageable(this.currentPage).subscribe(
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
      this.currentPage = 1;
      this.searchName();
    }
  }

  searchName(): void {
    this.modelService.findByNamePageable(this.name.value, this.currentPage).subscribe(
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
    if (this.currentPage < this.totalPages) {
      this.currentPage += 1;
      if (!this.isSearching) {
        this.retrieveModels();
      } else {
        this.searchName();
      }
    }
  }

  previousPage(): void {
    if (this.currentPage > 0) {
      this.currentPage -= 1;
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
