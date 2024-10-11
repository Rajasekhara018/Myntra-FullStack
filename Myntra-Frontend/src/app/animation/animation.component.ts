import { Component } from '@angular/core';

@Component({
  selector: 'app-animation',
  templateUrl: './animation.component.html',
  styleUrls: ['./animation.component.scss']
})
export class AnimationComponent {
  sections = document.querySelectorAll('.content');
  checkVisibility() {
    
    this.sections.forEach((section) => {
        const rect = section.getBoundingClientRect();
        const windowHeight = window.innerHeight;

        if (rect.top <= windowHeight * 0.75) {
            section.classList.add('visible');
        } else {
            section.classList.remove('visible');
        }
    });
} 
ngAfterViewChecked(){
  
  window.addEventListener('scroll', this.checkVisibility);
}

// Listen for the scroll event

}
