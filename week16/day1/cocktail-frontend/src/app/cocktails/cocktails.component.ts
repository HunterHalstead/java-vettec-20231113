import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';

@Component({
    selector: 'app-cocktails',
    standalone: true,
    templateUrl: './cocktails.component.html',
    styleUrl: './cocktails.component.css'
})
export class CocktailsComponent {

    // this constructor injects our backend service
    // to be used throughout this component
    constructor(private backend: BackendService) {

        this.backend.cocktailsByLetter.subscribe(data => {
            console.log(data);
        })

    }

}
