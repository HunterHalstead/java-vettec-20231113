import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Cocktail } from '../models/cocktail';

@Component({
    selector: 'app-cocktails',
    standalone: true,
    templateUrl: './cocktails.component.html',
    styleUrl: './cocktails.component.css'
})
export class CocktailsComponent {

    // local storage for the cocktails
    cocktails: Cocktail[] = [];

    // this constructor injects our backend service
    // to be used throughout this component
    constructor(private backend: BackendService) {

        this.backend.cocktailsByLetter.subscribe(data => {
            this.cocktails = data;

            console.log(this.cocktails);
        })

    }

}
