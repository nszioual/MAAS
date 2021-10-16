import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DomainService } from '../../services/domain.service';
import { Domain } from '../../model/domain';
import { faUpload } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-add-domain',
  templateUrl: './add-domain.component.html',
  styleUrls: ['./add-domain.component.css'],
})
export class AddDomainComponent implements OnInit {
  faUpload = faUpload;

  domainForm: FormGroup;
  submitted = false;
  selectedFile = null;
  selectedFileName = '';

  constructor(
    public fb: FormBuilder,
    private domainService: DomainService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.domainForm = this.fb.group({
      name: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(30),
          Validators.pattern('^[_A-z0-9]*((-|s)*[_A-z0-9])*$'),
        ],
      ],
      tags: [''],
    });
  }

  setFile(event): void {
    this.selectedFile = (event.target as HTMLInputElement).files[0];
    this.selectedFileName = this.selectedFile.name;
  }

  saveDomain(): void {
    this.submitted = true;

    if (!this.domainForm.valid) {
      return;
    }

    const domainData: any = new FormData();
    domainData.append('file', this.selectedFile, this.selectedFile.name);
    domainData.append(
      'domain',
      new Blob([JSON.stringify(this.prepareDomainData())], {
        type: 'application/json',
      })
    );

    this.domainService.create(domainData).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['/domains']);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  get domainFormControl() {
    return this.domainForm.controls;
  }

  private prepareDomainData() {
    const domain = new Domain();
    domain.name = this.domainForm.value.name;
    domain.tags =
      this.domainForm.value.tags == ''
        ? []
        : this.domainForm.value.tags.replace(/\s/g, '').split(',');
    return domain;
  }
}
