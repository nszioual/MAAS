import { Component, OnInit } from '@angular/core';
import { ModelService } from '../../services/model.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { saveAs } from 'file-saver';
import { faUpload, faDownload } from '@fortawesome/free-solid-svg-icons';
import { Similarity } from "../../model/similarity";

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
  ) {
  }

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
      type: ['', [Validators.required]],
      path: ['', [Validators.required]],
      description: [
        '',
        [
          Validators.maxLength(350)
        ],
      ],
      domains: [''],
      file_name: [''],
      file: [null],
    });
    this.getModel(this.route.snapshot.paramMap.get('id'));
    // this.getDomains();
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
          type: data.model.modelingLanguage,
          description: data.model.description,
          path: data.model.path,
          domains: data.model.domains
        });
        const domains = this.currentModelForm.value.domains;
        Object.keys(domains).forEach((key) => {
          const similarity = new Similarity();
          similarity.domain = key;
          similarity.result = Math.round(domains[key] * 100);
          this.similarities.push(similarity);
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
    if (this.currentModelForm.valid) {
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
            this.versions = data.versions;
            this.submitted = false;
          },
          (error) => {
            console.log(error);
          }
        );
    }
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
