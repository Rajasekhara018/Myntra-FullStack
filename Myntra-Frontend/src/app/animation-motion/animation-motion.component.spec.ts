import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimationMotionComponent } from './animation-motion.component';

describe('AnimationMotionComponent', () => {
  let component: AnimationMotionComponent;
  let fixture: ComponentFixture<AnimationMotionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnimationMotionComponent]
    });
    fixture = TestBed.createComponent(AnimationMotionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
