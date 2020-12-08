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
  hour: number;
  min: number;
  second: number;
  type: string;

  constructor() {}

  ngOnInit(): void {
    // this.timeObservable$ = interval(1000);
    this.today = new Date();
    setInterval(() => {
      this.today = new Date();
      this.hour = this.today.getHours();
      this.min = this.today.getMinutes();
      this.second = this.today.getSeconds();
    }, 1000);
  }

  // setTime(){
  //   this.ngOnInit()
  // }

  // tslint:disable-next-line:typedef
  clearSearch() {
    this.hour = null;
    this.min = null;
    this.second = null;
  }

}
