import { Routes } from '@angular/router';
import { CocktailsComponent } from './cocktails/cocktails.component';
import { HomeComponent } from './home/home.component';
import { FormComponent } from './form/form.component';
import { CocktailDetailsComponent } from './cocktail-details/cocktail-details.component';
import { CrudComponent } from './crud/crud.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'cocktails',
        component: CocktailsComponent
    },
    {
        path: 'form',
        component: FormComponent
    },
    {
        path: 'crud',
        component: CrudComponent
    },
    {
        path: 'cocktails/details/:idDrink',
        component: CocktailDetailsComponent
    }
];
