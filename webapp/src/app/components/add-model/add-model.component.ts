import { Component, OnInit } from '@angular/core';
import { ModelService } from 'src/app/services/model.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { faUpload } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import { AppConstants } from 'src/app/commons/app-constants';

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
      name: ['', [Validators.required]],
      description: ['', [Validators.maxLength(350)]],
      path: ['', [Validators.required]],
      type: ['', [Validators.required]],
      repoUrl: [''],
      stars: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      forks: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      branches: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
    });
  }

  setFile(event): void {
    this.selectedFile = (event.target as HTMLInputElement).files[0];
    this.selectedFileName = this.selectedFile.name;
    this.modelForm.patchValue({
      type: this.selectedFile.name.split('.').pop(),
    });
  }

  saveModel(): void {
    this.submitted = true;

    if (!this.modelForm.valid) {
      return;
    }

    const modelData: any = new FormData();
    modelData.append('file', this.selectedFile, this.selectedFile.name);
    modelData.append(
      'model',
      new Blob([JSON.stringify(this.modelForm.value)], {
        type: 'application/json',
      })
    );

    this.modelService.create(modelData).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['/models']);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  get modelFormControl() {
    return this.modelForm.controls;
  }
}
