import {Component, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.css']
})
export class TimerComponent implements  OnInit, OnDestroy {
  name = 'Angular';
  time = new Date();
  timer;

  constructor() { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.timer = setInterval(() => {
      this.time = new Date();
    }, 1000);
  }

  // tslint:disable-next-line:typedef
  ngOnDestroy(){
    clearInterval(this.timer);
  }

}


