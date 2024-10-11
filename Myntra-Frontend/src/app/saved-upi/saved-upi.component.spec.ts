import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavedUpiComponent } from './saved-upi.component';

describe('SavedUpiComponent', () => {
  let component: SavedUpiComponent;
  let fixture: ComponentFixture<SavedUpiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SavedUpiComponent]
    });
    fixture = TestBed.createComponent(SavedUpiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
