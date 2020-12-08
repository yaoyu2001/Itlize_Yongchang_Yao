import {Component, Directive, OnInit} from '@angular/core';
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
  hour: number;
  min: number;
  second: number;
  type: string;
  // interval: number;

  interval = setInterval(() => {
    this.today = new Date();
    this.hour = this.today.getHours();
    this.min = this.today.getMinutes();
    this.second = this.today.getSeconds();
  }, 1000);

  constructor() {}

  ngOnInit(): void {
    // this.timeObservable$ = interval(1000);
    // @ts-ignore
    this.interval();
  }
  // tslint:disable-next-line:typedef
  clearSearch() {
    // @ts-ignore
    this.interval = setInterval(() => {
      this.today = new Date();
      this.hour = this.today.getHours();
      this.min = this.today.getMinutes();
      this.second = this.today.getSeconds();
    }, 1000);
    // clearInterval(this.interval);
  }

  // tslint:disable-next-line:typedef
  typeSearch() {
    clearInterval(this.interval);
  }
}

// @Directive({
//   selector : 'input['
// })
