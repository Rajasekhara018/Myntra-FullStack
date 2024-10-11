import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RainJacketsComponent } from './rain-jackets.component';

describe('RainJacketsComponent', () => {
  let component: RainJacketsComponent;
  let fixture: ComponentFixture<RainJacketsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RainJacketsComponent]
    });
    fixture = TestBed.createComponent(RainJacketsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
