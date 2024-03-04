// importing packages to use in this component
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

// this is a descriptor
// like an annotation in Java, just for Angular
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'cocktail-frontend';
}
