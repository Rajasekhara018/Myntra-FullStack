import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SweatShirtsComponent } from './sweat-shirts.component';

describe('SweatShirtsComponent', () => {
  let component: SweatShirtsComponent;
  let fixture: ComponentFixture<SweatShirtsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SweatShirtsComponent]
    });
    fixture = TestBed.createComponent(SweatShirtsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
