import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManufacturerListComponent } from './manufacturer-list.component';

describe('ManufacturerListComponent', () => {
  let component: ManufacturerListComponent;
  let fixture: ComponentFixture<ManufacturerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManufacturerListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ManufacturerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
