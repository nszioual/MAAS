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
  offset = 0;
  limit = 8;
  isSearching: boolean;
  name = new FormControl('');

  constructor(private domainService: DomainService) {}

  ngOnInit(): void {
    this.retrieveDomains();
    this.isSearching = false;
  }

  retrieveDomains(): void {
    this.domainService.getAllPageAble(this.offset, this.limit).subscribe(
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
      this.offset = 0;
      this.searchName();
    }
  }

  searchName(): void {
    this.domainService.findByNamePageAble(this.name.value, this.offset, this.limit).subscribe(
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
    if (this.offset < this.totalPages) {
      this.offset += 1;
      if (!this.isSearching) {
        this.retrieveDomains();
      } else {
        this.searchName();
      }
    }
  }

  previousPage(): void {
    if (this.offset > 0) {
      this.offset -= 1;
      if (!this.isSearching) {
        this.retrieveDomains();
      } else {
        this.searchName();
      }
    }
  }
}
