import { Component, OnInit } from '@angular/core';
import { ModelService } from 'src/app/services/model.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { faUpload } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-model',
  templateUrl: './add-model.component.html',
  styleUrls: ['./add-model.component.css'],
})
export class AddModelComponent implements OnInit {
  faUpload = faUpload;

  modelForm: FormGroup;
  submitted = false;
  selectedFile = null;
  selectedFileName = '';

  constructor(
    public fb: FormBuilder,
    private modelService: ModelService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.modelForm = this.fb.group({
      name: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(30),
          Validators.pattern('^[_A-z0-9]*((-|s)*[_A-z0-9])*$'),
        ],
      ],
      type: ['', [Validators.required]],
      path: ['', [Validators.required]],
      description: [
        '',
        [
          Validators.maxLength(350)
        ],
      ],
    });
  }

  setFile(event): void {
    this.selectedFile = (event.target as HTMLInputElement).files[0];
    this.selectedFileName = this.selectedFile.name;
    this.modelForm.patchValue({
      type: this.selectedFile.name.split('.').pop(),
    });
  }

  get modelFormControl() {
    return this.modelForm.controls;
  }

  saveModel(): void {
    this.submitted = true;
    if (this.modelForm.valid) {
      const formData: any = new FormData();
      formData.append('file', this.selectedFile, this.selectedFile.name);
      formData.append(
        'model',
        new Blob([JSON.stringify(this.modelForm.value)], {
          type: 'application/json',
        })
      );

      this.modelService.create(formData).subscribe(
        (response) => {
          console.log(response);
          this.router.navigate(['/models']);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
}
