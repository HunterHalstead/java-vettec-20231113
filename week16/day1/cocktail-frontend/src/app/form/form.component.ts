import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Cocktail } from '../models/cocktail';
import { CocktailComponent } from "../cocktail/cocktail.component";
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-form',
    standalone: true,
    templateUrl: './form.component.html',
    styleUrl: './form.component.css',
    imports: [FormsModule, CocktailComponent, CommonModule]
})
export class FormComponent {

  // ngModel properties
  strDrink: string = '';
  strGlass: string = '';
  strAlcoholic: string = '';
  strDrinkThumb: string = '';

  cocktail: Cocktail = new Cocktail('','','','','','','','','','');
  
  populateCocktailComponent() {
    this.cocktail.strDrink = this.strDrink;
    this.cocktail.strGlass = this.strGlass;
    this.cocktail.strAlcoholic = this.strAlcoholic;
    this.cocktail.strDrinkThumb = this.strDrinkThumb
  }

}
