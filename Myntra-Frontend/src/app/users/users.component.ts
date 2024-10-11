import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { PostService } from '../services/post.service';
import { animate, keyframes, query, stagger, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
    animations: [
      trigger('deleteItem', [
        // state('expanded', style({ height: '*', /*display: 'block',*/ color:'black' })),
        // state('collapsed', style({ height: '0px', maxHeight: '0', display: 'none', color: 'white' })),
        transition('expanded <=> collapsed', [animate('1000ms cubic-bezier(0.4, 0.0, 0.2, 1)')]),
      ]),
  
      trigger('rowUpdate', [
        transition('void => *', animate('600ms', keyframes([
          style({ backgroundColor: 'initial', boxShadow: 'none', offset: 0 }),
          style({ backgroundColor: '#eee', boxShadow: '0 0 5px #eee', offset: 0.1 }),
          style({ backgroundColor: 'initial', boxShadow: 'none', offset: 1 }),
        ])))
      ]),
      trigger("listAnimation", [
        transition("* => *", [
          // each time the binding value changes
          query(
            ":leave",
            [stagger(100, [animate("0.5s", style({ opacity: 0 }))])],
            { optional: true }
          ),
          query(
            ":enter",
            [
              style({ opacity: 0 }),
              stagger(100, [animate("0.5s", style({ opacity: 1 }))])
            ],
            { optional: true }
          )
        ])
      ]),
      trigger(
        'enterAnimation', [
        transition(':enter', [
          style({ transform: 'translateX(100%)', opacity: 0 }),
          animate('500ms', style({ transform: 'translateX(0)', opacity: 1, 'overflow-x': 'hidden' }))
        ]),
        transition(':leave', [
          style({ transform: 'translateX(0)', opacity: 1 }),
          animate('500ms', style({ transform: 'translateX(100%)', opacity: 0 }))
        ])
      ]
      ),
      trigger('slideIn', [
        state('*', style({ 'overflow-y': 'hidden' })),
        state('void', style({ 'overflow-y': 'hidden' })),
        transition('* => void', [
          style({ height: '*' }),
          animate(250, style({ height: 0 }))
        ]),
        transition('void => *', [
          style({ height: '0' }),
          animate(250, style({ height: '*' }))
        ])
      ]),
    ],
})
export class UsersComponent implements OnInit {
  constructor(public dservice: PostService,) {

  }
  req = new requestObject();
  ngOnInit(): void {
    this.searchUser = new searchUsers();
    this.getAllData(0,5);
  }
  genders: string[] = ['Female', 'Male', 'other'];
  displayedColumns: string[] = ['firstName', 'lastName', 'userName', 'email', 'gender', 'dob'];
  dataSource = new Array<searchUsers>();
  length!:number;
  pageSize = 5;
  pageIndex = 0;
  pageSizeOptions = [5, 10, 25];

  hidePageSize = false;
  showPageSizeOptions = true;
  showFirstLastButtons = true;
  disabled = false;

  pageEvent!: PageEvent;
  searchUser = new searchUsers();

  getAllData(pageNo:number,pageSize:number ) {
    // this.searchUser.pageNo = 0;
    // this.searchUser.pageSize = 5;
    this.dservice.dopostPagination("http://localhost:6062/flipkart/register/getall", this.searchUser, pageNo, pageSize).subscribe((res: any) => {
      this.dataSource = res.object.content;
      this.length = res.object.totalElements;
      this.pageSize = res.object.size;
      this.pageIndex = res.object.number;
    }, err => {
      console.log(err);
    })
  }
  handlePageEvent(e: PageEvent) {
    this.pageEvent = e;
    this.length = e.length;
    this.pageSize = e.pageSize;
    this.pageIndex = e.pageIndex;
    this.getAllData(this.pageIndex, this.pageSize);
  }
  searchUsers(searchUser: searchUsers) {
    searchUser.pageNo = 0;
    searchUser.pageSize = 5;
    this.req.objct = this.searchUser;
    this.dservice.postdata("http://localhost:6062/flipkart/register/getall", JSON.stringify(this.req)).subscribe((res: any) => {
      this.dataSource = res.object.content;
      this.length = res.object.totalElements;
      this.pageSize = res.object.size;
      this.pageIndex = res.object.number;
    }, err => {
      console.log(err);
    })
  }
}
export class searchUsers {
  firstName!: string;
  lastName!: string;
  email!: string;
  userName!: string;
  gender!: string;
  dob!: string;
  pageNo!: number;
  pageSize!: number;
}
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

export class requestObject {
  objct: any;
  pageNo!: number;
  pageSize!: number;
}

const ELEMENT_DATA: PeriodicElement[] = [
  { position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H' },
  { position: 2, name: 'Helium', weight: 4.0026, symbol: 'He' },
  { position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li' },
  { position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be' },
  { position: 5, name: 'Boron', weight: 10.811, symbol: 'B' },
  { position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C' },
  { position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N' },
  { position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O' },
  { position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F' },
  { position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne' },
];