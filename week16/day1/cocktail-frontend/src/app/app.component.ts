// importing packages to use in this component
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./header/header.component";
import { FooterComponent } from "./footer/footer.component";
import { NavComponent } from "./nav/nav.component";

// this is a descriptor
// like an annotation in Java, just for Angular
@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, HeaderComponent, FooterComponent, NavComponent]
})
export class AppComponent {
  title = 'cocktail-frontend';
}
