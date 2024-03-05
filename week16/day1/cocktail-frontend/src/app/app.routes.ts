import { Routes } from '@angular/router';
import { CocktailsComponent } from './cocktails/cocktails.component';
import { FooterComponent } from './footer/footer.component';

export const routes: Routes = [
    {
        path: 'cocktails',
        component: CocktailsComponent
    }
];
