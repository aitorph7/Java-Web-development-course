import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HolamundoComponent } from './holamundo.component';

describe('HolamundoComponent', () => {
  let component: HolamundoComponent;
  let fixture: ComponentFixture<HolamundoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HolamundoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HolamundoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
