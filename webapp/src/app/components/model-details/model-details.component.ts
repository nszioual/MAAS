import { Component, OnInit } from '@angular/core';
import { ModelService } from '../../services/model.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { saveAs } from 'file-saver';
import { faUpload, faDownload } from '@fortawesome/free-solid-svg-icons';
import { Similarity } from '../../model/similarity';
import { AppConstants } from 'src/app/commons/app-constants';

@Component({
  selector: 'app-model-details',
  templateUrl: './model-details.component.html',
  styleUrls: ['./model-details.component.css'],
})
export class ModelDetailsComponent implements OnInit {
  faUpload = faUpload;
  faDownload = faDownload;

  currentModelForm: FormGroup;
  submitted = false;
  versions = null;
  selectedFile = null;
  selectedFileName = '';
  message = '';

  similarities: Similarity[] = [];

  constructor(
    public fb: FormBuilder,
    private modelService: ModelService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.currentModelForm = this.fb.group({
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
      description: ['', [Validators.maxLength(350)]],
      path: ['', [Validators.required]],
      type: ['', [Validators.required]],
      repoUrl: [
        '',
        [Validators.required],
      ],
      stars: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      forks: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      branches: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
    });
    this.getModel(this.route.snapshot.paramMap.get('id'));
  }

  setFile(event): void {
    this.selectedFile = (event.target as HTMLInputElement).files[0];
    this.selectedFileName = this.selectedFile.name;
    this.currentModelForm.patchValue({
      type: this.selectedFile.name.split('.').pop(),
    });
  }

  getModel(id): void {
    this.modelService.get(id).subscribe(
      (data) => {
        this.currentModelForm.patchValue({
          id: data.model.id,
          name: data.model.name,
          description: data.model.description,
          path: data.model.path,
          type: data.model.modelingLanguage,
          repoUrl: data.model.repository.url,
          stars: data.model.repository.stars,
          forks: data.model.repository.forks,
          branches: data.model.repository.branches,
        });
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  get modelFormControl() {
    return this.currentModelForm.controls;
  }

  updateModel(): void {
    this.submitted = true;
    if (!this.currentModelForm.valid) {
      return;
    }
    const formData: any = new FormData();
    formData.append(
      'model',
      new Blob([JSON.stringify(this.currentModelForm.value)], {
        type: 'application/json',
      })
    );

    if (this.selectedFile) {
      formData.append('file', this.selectedFile, this.selectedFile.name);
    }

    this.modelService
      .update(this.currentModelForm.get('id').value, formData)
      .subscribe(
        (data) => {
          console.log(data);
          this.message = 'The model was updated successfully!';
          this.submitted = false;
        },
        (error) => {
          console.log(error);
        }
      );
  }

  deleteModel(): void {
    this.modelService.delete(this.currentModelForm.get('id').value).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['/models']);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  download(version): void {
    this.modelService.downloadVersion(version.id).subscribe(
      (data) => {
        console.log(data);
        saveAs(data, `${version.name}.${version.type}`);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
