// ======= DO NOT EDIT THIS FILE ============

class Boat {

    String owner;
    int price;
    int color;

    Boat(String owner, int price, int color) {
        this.owner = owner;
        this.price = price;
        this.color = color;
    }    

    public String toString() {
        return ("(" + owner + "," + price + "," + color + ")");
    }
}