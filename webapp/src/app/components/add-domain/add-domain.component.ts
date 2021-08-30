import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DomainService } from '../../services/domain.service';
import { Domain } from "../../model/domain";

@Component({
  selector: 'app-add-domain',
  templateUrl: './add-domain.component.html',
  styleUrls: ['./add-domain.component.css']
})
export class AddDomainComponent implements OnInit {
  domainForm: FormGroup;
  submitted = false;

  domain: Domain;

  constructor(
    public fb: FormBuilder,
    private domainService: DomainService,
    private router: Router
  ) {
    this.domain = new Domain();
  }

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
      tags: [
        '',
        [
          Validators.required
        ],
      ],
    });
  }

  get domainFormControl() {
    return this.domainForm.controls;
  }

  saveDomain(): void {
    this.submitted = true;
    if (this.domainForm.valid) {
      this.domain.name = this.domainForm.value.name;
      this.domain.tags = this.domainForm.value.tags.replace(/\s/g, '').split(',');
      this.domainService.create(this.domain).subscribe(
        (response) => {
          console.log(response);
          this.router.navigate(['/domains']);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
}
