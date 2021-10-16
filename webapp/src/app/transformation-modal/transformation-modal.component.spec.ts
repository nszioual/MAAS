import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransformationModalComponent } from './transformation-modal.component';

describe('TransformationModalComponent', () => {
  let component: TransformationModalComponent;
  let fixture: ComponentFixture<TransformationModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransformationModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransformationModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
