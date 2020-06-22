// Interview CampLevel: Medium
// You are given stock prices and the corresponding day of each stock price.
// (32, 1), (45, 1), (37,2), (42,3), .. Here, 32 is the price and 1 is the day of the price.

// Your system should be able to tellthe maximum stock price in the last 3 days.

public class StockPriceWithTime {
    Queue<Price> q;
    int window;

    // define the windowdays for which you want max price of stock
    public StockPriceWithTime(int windowDays) {        
        q = new LinkedList<>();        
        window = windowDays;    
    }

    //add the queue to have only items wihing three days range
    public void addPrice(int price, int day) {
        while(!q.isEmpty() && q.peek().getDay() < (day - window + 1))
            q.remove();
        
        q.add(new Price(price, day));
    }

    // Returns max price in last 3 days
    public int getMaxPrice(){
        int maxPrice = 0;
        Iterator<Price> iter = q.iterator();
        while (iter.hasNext()) {
            int price = ((Price) iter.next()).getPrice();
            if (price > maxPrice)
                maxPrice = price;
        }
        return maxPrice;
    }
}

//helper code
public class Price {    
    int price;    
    int day;    
    
    public Price(int price, int day) {        
        super();        
        this.price = price;        
        this.day = day;    
    }
}
