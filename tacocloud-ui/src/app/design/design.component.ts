import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { CartService } from '../cart/cart-service';

@Component({
  selector: 'app-design',
  templateUrl: './design.component.html',
  styleUrls: ['./design.component.css']
})

@Injectable()
export class DesignComponent implements OnInit {

  model = new Model();

  allIngredients: Ingredient[];
  wraps: Ingredient[];
  proteins: Ingredient[];
  veggies: Ingredient[];
  cheeses: Ingredient[];
  sauces: Ingredient[];

  constructor(private httpClient: HttpClient, private router: Router, private cart: CartService) {
    this.allIngredients = [];
    this.wraps = [];
    this.proteins = [];
    this.veggies = [];
    this.cheeses = [];
    this.sauces = [];
  }

  ngOnInit(): void {
    this.httpClient.get<Ingredient[]>('http://localhost:8080/ingredientsx')
      .subscribe((data: Ingredient[]) => {
        this.allIngredients = data;
        this.wraps = this.allIngredients.filter(w => w.type === 'WRAP');
        this.proteins = this.allIngredients.filter(p => p.type === 'PROTEIN');
        this.veggies = this.allIngredients.filter(v => v.type === 'VEGGIES');
        this.cheeses = this.allIngredients.filter(c => c.type === 'CHEESE');
        this.sauces = this.allIngredients.filter(s => s.type === 'SAUCE');
      });
  }

  updateIngredients(ingredient: Ingredient, event: any): void {
    if (event.target.checked) {
      this.model.ingredients.add(ingredient);
    } else {
      this.model.ingredients.delete(ingredient);
    }
  }

  onSubmit(): void {
    this.httpClient.post(
      'http://localhost:8080/design',
      this.model, {
        headers: new HttpHeaders().set('Content-type', 'application/json'),
      }
    ).subscribe(taco => this.cart.addToCart(taco));
  }

}

class Model {
  name = '';
  ingredients: Set<Ingredient> = new Set();
}

interface Ingredient {
  id: number;
  name: string;
  type: string;
}
