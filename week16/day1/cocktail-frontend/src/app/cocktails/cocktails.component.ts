import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Cocktail } from '../models/cocktail';
import { CommonModule } from '@angular/common';
import { CocktailComponent } from "../cocktail/cocktail.component";

@Component({
    selector: 'app-cocktails',
    standalone: true,
    templateUrl: './cocktails.component.html',
    styleUrl: './cocktails.component.css',
    imports: [CommonModule, CocktailComponent]
})
export class CocktailsComponent {

    // local storage for the cocktails
    cocktails: Cocktail[] = [];

    // toggle variable for table/grid view
    isTable: boolean = true;

    // this constructor injects our backend service
    // to be used throughout this component
    constructor(private backend: BackendService) {

        this.backend.cocktailsByLetter.subscribe(data => {
            this.cocktails = data;

            console.log(this.cocktails);
        })

    }

    // toggles the isTable value when you click the button
    viewToggle() {
        this.isTable = !this.isTable;
    }

}
