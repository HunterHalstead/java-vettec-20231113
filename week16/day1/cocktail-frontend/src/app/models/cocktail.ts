// this class is a model for an individual cocktail object
// we use it to homogenize/sanitize data coming in/out
export class Cocktail {
    // properties
    idDrink: string;
    strAlcoholic: string;
    strDrinkThumb: string;
    strGlass: string;
    strIngredient1: string;
    strIngredient2: string;
    strIngredient3: string;
    strIngredient4: string;
    strInstructions: string;

    // constructor
    constructor(idDrink: string,
                strAlcoholic: string,
                strDrinkThumb: string,
                strGlass: string,
                strIngredient1: string,
                strIngredient2: string,
                strIngredient3: string,
                strIngredient4: string,
                strInstructions: string) {
        this.idDrink = idDrink;
        this.strAlcoholic = strAlcoholic;
        this.strDrinkThumb = strDrinkThumb;
        this.strGlass = strGlass;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strInstructions = strInstructions;
    }
}
