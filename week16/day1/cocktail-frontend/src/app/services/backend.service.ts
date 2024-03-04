import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

// this decorator allows this to be dependency-injected into other components as needed
@Injectable({
  providedIn: 'root'
})
export class BackendService {

  // where we store raw cocktails from the DB
  cocktailsByLetterRaw: any[] = [];

  // a BehaviorSubject maintains a state and notifies an Observable when it has changed
  cocktailsByLetterSubject = new BehaviorSubject<any[]>([]);

  // creating an Observable to notify subscribers that our Subject has undergone a change
  cocktailsByLetter = this.cocktailsByLetterSubject.asObservable();

  constructor(private http: HttpClient) { 
    this.getAllCocktailsByLetter('g');
  }

  getAllCocktailsByLetter(letter: String) {
    // takes in a URL and an observable type
    this.http.get('https://www.thecocktaildb.com/api/json/v1/1/search.php?f=' + letter, { observe: 'response' })
             .subscribe(data => {

              // cleaning out the raw array
              // so we don't have duplicates
              this.cocktailsByLetterRaw = [];

              // creating a possibly null holder for data
              let temp: any = data.body;

              // looping through the data and adding
              // each cocktail to the array
              for (let cocktail of temp['drinks']) {
                this.cocktailsByLetterRaw.push(cocktail);
              }

              this.cocktailsByLetterSubject.next(this.cocktailsByLetterRaw);
             });
  }
}
