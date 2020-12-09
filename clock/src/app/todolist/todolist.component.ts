import {Component, OnChanges, OnDestroy, OnInit, PipeTransform} from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { FormControl } from '@angular/forms';

import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

interface Country {
  name: string;
  flag: string;
  area: number;
  population: number;
}

class Item {
  name: string;
}

let ITEMS: Item[] = [
  {
    name: 'Item1'
  },
  {
    name: 'Item2'
  },
  {
    name: 'Item3'
  },
  ];

function searchItem(text: string, pipe: PipeTransform): Item[] {
  return ITEMS.filter(item => {
    const term = text.toLowerCase();
    return item.name.toLowerCase().includes(term);
  });
}

@Component({
  selector: 'app-todolist',
  templateUrl: './todolist.component.html',
  providers: [DecimalPipe]
})
export class TodolistComponent implements OnInit, OnChanges, OnDestroy{
  items$: Observable<Item[]>;
  ITEMS: Item[] = [
    {
      name: 'Item1'
    },
    {
      name: 'Item2'
    },
    {
      name: 'Item3'
    },
  ];
  filter = new FormControl('');
  value = '';
  ITEMS_TEMP: Item[];

  public selectedName: string;

  ngOnInit(): void {
    console.log('Project Init');
    // this.interval();
  }
  ngOnChanges(): void {
    console.log('Project Change');
  }
  ngOnDestroy(): void {
    console.log('Project Destroy');
  }

  constructor(pipe: DecimalPipe) {
    // Object.assign(this.ITEMS, this.ITEMS_TEMP);
    this.items$ = this.filter.valueChanges.pipe(
      startWith(''),
      map(text => searchItem(text, pipe))
    );
  }

  // tslint:disable-next-line:typedef
  onEnter(value: string) {
    this.value = value;
    const tempItem = new Item();
    tempItem.name = value;
    this.ITEMS.push(tempItem);
    // pipe = P
    // @ts-ignore
    // this.items$ = this.filter.valueChanges.pipe(
    //   startWith(''),
    //   map(text => searchItem(text, DecimalPipe))
    // );
  }

  // tslint:disable-next-line:typedef
  onDelete(index){
    const node = this.ITEMS[index];
    this.ITEMS = this.ITEMS.filter(item => item !== node);
    // this.items$ = this.filter.valueChanges.pipe(
    //   startWith(''),
    //   map(text => searchItem(text,DecimalPipe))
    // );
  }

  // tslint:disable-next-line:typedef
  public highlightRow(emp) {
    // alert(emp.name);
    this.selectedName = emp.name;
  }

  // tslint:disable-next-line:typedef
  public inputFilter(text) {
    // alert(emp.name);
    this.ITEMS_TEMP = this.ITEMS;
    // Object.assign(this.ITEMS_TEMP, this.ITEMS);
    alert(text);
    if (text){
      this.ITEMS = this.ITEMS.filter(item => item.name === text);
    }else {
      alert(this.ITEMS_TEMP);
      this.ITEMS = this.ITEMS_TEMP;
    }
  }
}
