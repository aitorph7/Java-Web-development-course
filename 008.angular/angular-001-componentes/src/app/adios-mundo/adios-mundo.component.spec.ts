import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdiosMundoComponent } from './adios-mundo.component';

describe('AdiosMundoComponent', () => {
  let component: AdiosMundoComponent;
  let fixture: ComponentFixture<AdiosMundoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdiosMundoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdiosMundoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
