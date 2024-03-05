import { Component, Input } from '@angular/core';
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

}
