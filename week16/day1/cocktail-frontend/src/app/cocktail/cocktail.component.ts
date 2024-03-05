import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Cocktail } from '../models/cocktail';

@Component({
  selector: 'app-cocktail',
  standalone: true,
  imports: [],
  templateUrl: './cocktail.component.html',
  styleUrl: './cocktail.component.css'
})
export class CocktailComponent {

  // Input receives data from the parent component
  @Input() cocktail: Cocktail = new Cocktail('', '', '', '', '', '', '', '', '', '');

  // Output sends data up to the parent component
  @Output() deleteCocktailEvent = new EventEmitter<Cocktail>();

  // emitting an event when the user clicks the X in the component
  emitDeleteCocktailEvent() {
    this.deleteCocktailEvent.emit(this.cocktail);
  }

}
