import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FilterService } from '../../services/filter.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-model-filter',
  templateUrl: './model-filter.component.html',
  styleUrls: ['./model-filter.component.css']
})
export class ModelFilterComponent implements OnInit {
  submitted = false;
  filtered = false;
  showTransformationModal = false;
  searchForm: FormGroup;

  predicates: any = ['>', '<', '=', '!'];
  formats: any = ['bpmn', 'epml'];
  target: string;

  totalElements = 0;

  constructor(
    public fb: FormBuilder,
    private filterService: FilterService
  ) {
  }

  ngOnInit(): void {
    this.searchForm = this.fb.group({
      name: ['', []],
      format: ['', []],
      target: ['', []],
      elements: this.fb.group({
        edgeCount: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        }),
        taskCount: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        }),
        eventCount: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        }),
        andJoinCount: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        }),
        andSplitCount: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        }),
        orJoinCount: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        }),
        orSplitCount: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        }),
        xorJoinCount: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        }),
        xorSplitCount: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        })
      }),
      repository: this.fb.group({
        repositoryName: [''],
        numberOfStars: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        }),
        numberOfForks: this.fb.group({
          predicate: [''],
          value: ['', Validators.pattern('^[0-9]+$')]
        })
      })
    });
  }

  filterModels(): void {
    this.submitted = true;
    this.filtered = true;
    this.filterService.search(this.searchForm.value).subscribe(
      (data) => {
        this.totalElements = data.totalElements;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );

  }

  download(): any {
      this.showTransformationModal = true;
  }

  downloadToTarget(transformation): void {
    this.showTransformationModal = false;
    this.filterService.download(transformation.target).subscribe(
      (data) => {
        console.log(data);
        saveAs(data, `bundle.zip`);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  stringEmpty(str): boolean {
    return (!str || str.length === 0);
  }
}
