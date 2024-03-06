import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Cocktail } from '../models/cocktail';

// this decorator allows this to be dependency-injected into other components as needed
@Injectable({
  providedIn: 'root'
})
export class BackendService {

  // where we store raw cocktails from the DB
  cocktailsByLetterRaw: Cocktail[] = [];

  // a BehaviorSubject maintains a state and notifies an Observable when it has changed
  cocktailsByLetterSubject = new BehaviorSubject<Cocktail[]>([]);

  // creating an Observable to notify subscribers that our Subject has undergone a change
  cocktailsByLetter = this.cocktailsByLetterSubject.asObservable();

  // saving our details cocktail
  detailSubject = new BehaviorSubject<Cocktail>(new Cocktail('','','','','','','','','',''));
  detail = this.detailSubject.asObservable();

  constructor(private http: HttpClient) { 
    this.getAllCocktailsByLetter('g');
  }

  // getting all cocktails starting with a certain letter
  getAllCocktailsByLetter(letter: string) {
    // takes in a URL and an observable type
    this.http.get<any>('https://www.thecocktaildb.com/api/json/v1/1/search.php?f=' + letter, { observe: 'response' })
             .subscribe(data => {

              // cleaning out the raw array
              // so we don't have duplicates
              this.cocktailsByLetterRaw = [];

              // looping through the data and adding
              // each cocktail to the array
              for (let cocktail of data.body.drinks) {
                this.cocktailsByLetterRaw.push(new Cocktail(cocktail.idDrink,
                                                            cocktail.strDrink,
                                                            cocktail.strAlcoholic,
                                                            cocktail.strDrinkThumb,
                                                            cocktail.strGlass,
                                                            cocktail.strIngredient1,
                                                            cocktail.strIngredient2,
                                                            cocktail.strIngredient3,
                                                            cocktail.strIngredient4,
                                                            cocktail.strInstructions));
              }

              this.cocktailsByLetterSubject.next(this.cocktailsByLetterRaw);
             });
  }

  // getting a single cocktail via id
  getCocktailById(idDrink: string) {
    
    this.http.get<any>('https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=' + idDrink, { observe: 'response' })
             .subscribe(data => {

              this.detailSubject.next(new Cocktail(data.body.drinks[0].idDrink,
                                                    data.body.drinks[0].strDrink,
                                                    data.body.drinks[0].strAlcoholic,
                                                    data.body.drinks[0].strDrinkThumb,
                                                    data.body.drinks[0].strGlass,
                                                    data.body.drinks[0].strIngredient1,
                                                    data.body.drinks[0].strIngredient2,
                                                    data.body.drinks[0].strIngredient3,
                                                    data.body.drinks[0].strIngredient4,
                                                    data.body.drinks[0].strInstructions));
             });
  }
}
