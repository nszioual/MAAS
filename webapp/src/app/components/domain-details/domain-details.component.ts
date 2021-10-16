import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DomainService } from '../../services/domain.service';
import { Domain } from '../../model/domain';
import { faUpload } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-domain-details',
  templateUrl: './domain-details.component.html',
  styleUrls: ['./domain-details.component.css'],
})
export class DomainDetailsComponent implements OnInit {
  faUpload = faUpload;

  currentDomainForm: FormGroup;
  submitted = false;
  message = '';
  selectedFile = null;
  selectedFileName = '';

  constructor(
    public fb: FormBuilder,
    private domainService: DomainService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.currentDomainForm = this.fb.group({
      id: [''],
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
    this.getDomain(this.route.snapshot.paramMap.get('id'));
  }

  setFile(event): void {
    this.selectedFile = (event.target as HTMLInputElement).files[0];
    this.selectedFileName = this.selectedFile.name;
  }

  getDomain(id): void {
    this.domainService.get(id).subscribe(
      (data) => {
        this.currentDomainForm.patchValue({
          id: data.domain.id,
          name: data.domain.name,
          tags: data.domain.tags.join(),
        });
        console.log(this.currentDomainForm.value);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  get domainFormControl() {
    return this.currentDomainForm.controls;
  }

  updateDomain(): void {
    this.submitted = true;

    if (!this.currentDomainForm.valid) {
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

    this.domainService
      .update(this.currentDomainForm.get('id').value, domainData)
      .subscribe(
        (data) => {
          console.log(data);
          this.message = 'The domain was updated successfully!';
          this.submitted = false;
        },
        (error) => {
          console.log(error);
        }
      );
  }

  deleteDomain(): void {
    this.domainService.delete(this.currentDomainForm.get('id').value).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['/domains']);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  private prepareDomainData() {
    const domain = new Domain();
    domain.name = this.currentDomainForm.value.name;
    domain.tags =
      this.currentDomainForm.value.tags == ''
        ? []
        : this.currentDomainForm.value.tags.replace(/\s/g, '').split(',');
    return domain;
  }
}
