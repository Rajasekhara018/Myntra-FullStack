import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlazersCoatsComponent } from './blazers-coats.component';

describe('BlazersCoatsComponent', () => {
  let component: BlazersCoatsComponent;
  let fixture: ComponentFixture<BlazersCoatsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BlazersCoatsComponent]
    });
    fixture = TestBed.createComponent(BlazersCoatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
