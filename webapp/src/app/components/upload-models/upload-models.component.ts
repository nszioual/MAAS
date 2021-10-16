import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { faUpload } from '@fortawesome/free-solid-svg-icons';
import { UploadService } from '../../services/upload.service';

@Component({
  selector: 'app-upload-models',
  templateUrl: './upload-models.component.html',
  styleUrls: ['./upload-models.component.css'],
})
export class UploadModelsComponent implements OnInit {
  faUpload = faUpload;

  uploadForm: FormGroup;
  submitted = false;
  selectedFile = null;
  selectedFileName = '';

  urlRegex =
    "'^(http:\\\\/\\\\/www\\\\.|https:\\\\/\\\\/www\\\\.|http:\\\\/\\\\/|https:\\\\/\\\\/)?[a-z0-9]+([\\\\-\\\\.]{1}[a-z0-9]+)*\\\\.[a-z]{2,5}(:[0-9]{1,5})?(\\\\/.*)?$";

  constructor(
    public fb: FormBuilder,
    private uploadService: UploadService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.uploadForm = this.fb.group({
      repoUrl: ['', [Validators.required, Validators.pattern(this.urlRegex)]],
      stars: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      forks: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      branches: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
    });
  }

  setFile(event): void {
    this.selectedFile = (event.target as HTMLInputElement).files[0];
    this.selectedFileName = this.selectedFile.name;
  }

  get uploadFormControl(): any {
    return this.uploadForm.controls;
  }

  saveModels(): void {
    this.submitted = true;
    if (this.uploadForm.valid) {
      const formData: any = new FormData();
      formData.append('file', this.selectedFile, this.selectedFile.name);
      formData.append(
        'repository',
        new Blob([JSON.stringify(this.uploadForm.value)], {
          type: 'application/json',
        })
      );

      this.uploadService.create(formData).subscribe(
        (response) => {
          console.log(response);
          // this.router.navigate(['/models']);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
}
