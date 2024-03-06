import { Component } from '@angular/core';
// necessary for ngModel to work
import { FormsModule } from '@angular/forms';
import { Cocktail } from '../models/cocktail';
import { CocktailComponent } from "../cocktail/cocktail.component";
// necessary for *ngIf to work
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-form',
    standalone: true,
    templateUrl: './form.component.html',
    styleUrl: './form.component.css',
    // also required to be included here
    imports: [FormsModule, CocktailComponent, CommonModule]
})
export class FormComponent {

  // ngModel properties
  strDrink: string = '';
  strGlass: string = '';
  strAlcoholic: string = '';
  strDrinkThumb: string = '';

  // a raw cocktail object that feeds down to the child component
  cocktail: Cocktail = new Cocktail('','','','','','','','','','');
  
  // a function to take the form inputs and fill in the Cocktail object
  populateCocktailComponent() {
    this.cocktail.strDrink = this.strDrink;
    this.cocktail.strGlass = this.strGlass;
    this.cocktail.strAlcoholic = this.strAlcoholic;
    this.cocktail.strDrinkThumb = this.strDrinkThumb
  }

}
