import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SweatersComponent } from './sweaters.component';

describe('SweatersComponent', () => {
  let component: SweatersComponent;
  let fixture: ComponentFixture<SweatersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SweatersComponent]
    });
    fixture = TestBed.createComponent(SweatersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
