import {Component, OnInit} from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'clock';
  today: Date;
  name = '';
  username: string;

  constructor() {}

  ngOnInit(): void {
    // this.timeObservable$ = interval(1000);
    this.today = new Date();
    setInterval(() => {
      this.today = new Date();
    }, 1000);
  }
  // tslint:disable-next-line:typedef
  setValue() {
    this.name = 'Nancy';
  }
}
