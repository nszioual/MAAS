import { Component, OnInit } from '@angular/core';
import { DomainService } from '../../services/domain.service';
import { faEdit, faPlus } from '@fortawesome/free-solid-svg-icons';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-domains-list',
  templateUrl: './domains-list.component.html',
  styleUrls: ['./domains-list.component.css']
})
export class DomainsListComponent implements OnInit {
  faEdit = faEdit;
  faPlus = faPlus;

  domains: any;
  totalElements: number;
  totalPages: number;
  currentPage = 0;
  isSearching: boolean;
  name = new FormControl('');

  constructor(private domainService: DomainService) {}

  ngOnInit(): void {
    this.retrieveDomains();
    this.isSearching = false;
  }

  retrieveDomains(): void {
    this.domainService.getAllPageable(this.currentPage).subscribe(
      (data) => {
        this.domains = data.domains;
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
      this.currentPage = 0;
      this.searchName();
    }
  }

  searchName(): void {
    this.domainService.findByNamePageable(this.name.value, this.currentPage).subscribe(
      (data) => {
        this.domains = data.domains;
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
        this.retrieveDomains();
      } else {
        this.searchName();
      }
    }
  }

  previousPage(): void {
    if (this.currentPage > 0) {
      this.currentPage -= 1;
      if (!this.isSearching) {
        this.retrieveDomains();
      } else {
        this.searchName();
      }
    }
  }

  getNumberOfTags(domain) {
    return Object.keys(domain.tags).length;
  }
}
