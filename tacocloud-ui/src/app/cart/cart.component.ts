import { Component, Injectable, OnInit } from '@angular/core';
import { CartService } from './cart-service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CartItem } from './cart-item';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})

@Injectable()
export class CartComponent implements OnInit {

  model = new Model();

  constructor(private cart: CartService, private httpClient: HttpClient) {
    this.cart = cart;
  }

  ngOnInit(): void {
  }

  get cartItems(): CartItem[] {
    return this.cart.getItemsInCart();
  }

  get cartTotal(): number {
    return this.cart.getCartTotal();
  }

  onSubmit(): void {
    this.cart.getItemsInCart().forEach(cartItem => {
      this.model.tacos.push(cartItem.taco);
    });

    this.httpClient.post(
      'http://localhost:8080/orders',
      this.model, {
        headers: new HttpHeaders()
          .set('Content-type', 'application/json')
          .set('Accept', 'application/json'),
      }
    ).subscribe(r => this.cart.emptyCart());
  }

}

class Model {
  deliveryName = '';

  deliveryStreet = '';

  deliveryState = '';

  deliveryCity = '';

  deliveryZip = '';

  ccNumber = '';

  ccExpiration = '';

  ccCVV = '';

  tacos: any[] = [];
}
