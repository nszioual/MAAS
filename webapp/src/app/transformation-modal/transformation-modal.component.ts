import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-transformation-modal',
  templateUrl: './transformation-modal.component.html',
  styleUrls: ['./transformation-modal.component.css']
})
export class TransformationModalComponent implements OnInit {
  extensions: any = ['bpmn', 'epml'];
  modalForm: FormGroup;

  @Output()
  onClose = new EventEmitter();

  constructor(public fb: FormBuilder) {}

  ngOnInit(): void {
    this.modalForm = this.fb.group({
      target: ['', []]
    });
  }

  cancel() {
    this.onClose.emit(null);
  }

  confirm() {
    this.onClose.emit(this.modalForm.value);
  }
}
