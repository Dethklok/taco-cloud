import { CartItem } from './cart-item';

export class CartService {

  items$: CartItem[] = [];

  constructor() {
    this.items$ = [];
  }

  addToCart(taco: any): void {
    this.items$.push(new CartItem(taco));
  }

  getItemsInCart(): CartItem[] {
    return this.items$;
  }

  getCartTotal(): number {
    return this.items$.reduce((total, cartItem) => total += cartItem.lineTotal, 0);
  }

  emptyCart(): void {
    this.items$ = [];
  }

}
