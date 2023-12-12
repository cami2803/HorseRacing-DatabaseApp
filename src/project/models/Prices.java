package project.models;

import java.util.ArrayList;
import java.util.List;

public class Prices {
    private List<Price> prices;

    public Prices() {
        this.prices = new ArrayList<>();
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
