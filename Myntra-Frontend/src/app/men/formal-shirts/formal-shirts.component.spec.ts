import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormalShirtsComponent } from './formal-shirts.component';

describe('FormalShirtsComponent', () => {
  let component: FormalShirtsComponent;
  let fixture: ComponentFixture<FormalShirtsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormalShirtsComponent]
    });
    fixture = TestBed.createComponent(FormalShirtsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
