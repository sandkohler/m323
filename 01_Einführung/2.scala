object FunctionalShoppingCart {

    // calculate the discount percentage based on the items in the cart
    // if the cart contains a book, apply a 5% discount
    // if the cart does not contain a book, apply no discount
    def getDiscountPercentage(cart: List[String]): Double = {
      if (cart.exists(_.toLowerCase.contains("buch"))) 5.0 else 0.0
    }
  
    def main(args: Array[String]): Unit = {
      val cart1 = List("Apfel", "Buch: Scala Programmieren")
      println(s"Warenkorb: $cart1")
      println(s"Rabatt: ${getDiscountPercentage(cart1)}%")
  
      val cart2 = List("Apfel", "Banane")
      println(s"Warenkorb: $cart2")
      println(s"Rabatt: ${getDiscountPercentage(cart2)}%")
    }
  }