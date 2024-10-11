import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PostService } from './services/post.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Online Shopping for women, men, kids';
  constructor(private router: Router,
    public dservice: PostService,
    public dialog: MatDialog) {
  }
}
