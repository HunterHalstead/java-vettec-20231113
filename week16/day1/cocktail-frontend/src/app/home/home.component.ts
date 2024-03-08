import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { StringExtenderPipe } from '../pipes/string-extender.pipe';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, StringExtenderPipe],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor() {
    this.strings2[4] = 'XXXXX';
    this.obj2.name = 'Marla';
  }

  // a raw number array to be transformed with CurrencyPipe
  nums: number[] = [3, 54.12, 114.23456, 9.989, 0.01111, 65, 10000000];

  // a raw date to be transformed with DatePipe
  date: number = Date.now();

  // a raw string array to be transformed with StringExtenderPipe
  // this is using our custom pipe
  strings: string[] = [ 'Hanson', 'Isaac', 'Taylor', 'Zac' ];

  // the spread operator looks like the rest operator, but it's not
  // used in this way, it spreads out the items in the array
  // and copies them to the new array
  // the new array has NOTHING TO DO with the original
  // so values changed in one do not affect the other
  strings2 = [ '90s music', ...this.strings, 'Also, Pearl Jam' ];

  // this works for object properties as well
  obj1 = { name: 'Joe', age: 123, hair: 'Mauve' };
  obj2 = { ...this.obj1, faveColor: 'Green' };
  
}
