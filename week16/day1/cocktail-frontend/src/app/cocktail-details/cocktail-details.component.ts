import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BackendService } from '../services/backend.service';
import { Cocktail } from '../models/cocktail';

@Component({
  selector: 'app-cocktail-details',
  standalone: true,
  imports: [],
  templateUrl: './cocktail-details.component.html',
  styleUrl: './cocktail-details.component.css'
})
export class CocktailDetailsComponent {

  detailCocktail = new Cocktail('','','','','','','','','','');

  constructor(private ar: ActivatedRoute,
              private backend: BackendService) {

    this.backend.getCocktailById(this.ar.snapshot.params['idDrink']);

    this.backend.detail.subscribe(data => {
      this.detailCocktail = data;
    })
  }

}
