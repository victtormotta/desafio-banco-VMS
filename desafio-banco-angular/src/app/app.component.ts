import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'desafio-banco-angular';

  constructor(private router: Router) { }

btnClick(s: string): void{
    this.router.navigateByUrl(s);
  }
}
