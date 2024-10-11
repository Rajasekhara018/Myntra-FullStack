import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenLatestComponent } from './men-latest.component';

describe('MenLatestComponent', () => {
  let component: MenLatestComponent;
  let fixture: ComponentFixture<MenLatestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MenLatestComponent]
    });
    fixture = TestBed.createComponent(MenLatestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
