import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Cocktail } from '../models/cocktail';
import { CommonModule } from '@angular/common';
import { CocktailComponent } from "../cocktail/cocktail.component";
import { FormsModule } from '@angular/forms';
import { DataTransferService } from '../services/data-transfer.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-cocktails',
    standalone: true,
    templateUrl: './cocktails.component.html',
    styleUrl: './cocktails.component.css',
    imports: [CommonModule, CocktailComponent, FormsModule]
})
export class CocktailsComponent {

    // local storage for the cocktails
    cocktails: Cocktail[] = [];

    // toggle variable for table/grid view
    isTable: boolean = true;

    // holder variable for search letter
    searchLetter: string = '';

    // this constructor injects our backend service
    // to be used throughout this component
    constructor(private backend: BackendService,
                private dt: DataTransferService,
                private router: Router) {

        this.backend.cocktailsByLetter.subscribe(data => {
            this.cocktails = data;
        })

    }

    // toggles the isTable value when you click the button
    viewToggle() {
        this.isTable = !this.isTable;
    }

    // removes a cocktail from the array when clicking table row X
    // the splice method for arrays takes out and/or adds in elements at a specified spot
    // first parameter = index at which to cut, second = how many to remove, starting at that index
    // third (optional) parameter = what to insert at that spot
    removeCocktailTable(idDrink: string) {
        for (let cocktail of this.cocktails) {
            if (cocktail.idDrink === idDrink) {
                this.cocktails.splice(this.cocktails.indexOf(cocktail), 1);
            }
        }
    }

    removeCocktailGrid(cocktail: Cocktail, index: number) {
        console.log(cocktail);
        this.cocktails.splice(index, 1);
    }

    updateLetter() {
        this.backend.getAllCocktailsByLetter(this.searchLetter);
    }

    // calling to our data-transfer service to update favorite
    updateFavorite(favoriteDrink: string) {
        this.dt.updateFavoriteDrink(favoriteDrink);
    }

    getDetails(idDrink: string) {
        this.router.navigate(['cocktails/details/' + idDrink]);
    }

}
