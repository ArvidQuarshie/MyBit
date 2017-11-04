package Models;

/**
 * Created by android on 10/11/17.
 *
 *Pojo for the bitcoin
 */

public class BitCoinObject {

    private String USD,EUR;
    private Double BTC;


    public BitCoinObject ( String USD , String EUR){

        this.USD =  USD;
        this.EUR = EUR;

    }


    public BitCoinObject ( ){

    }
    public String getUSD() {
        return USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public String getEUR() {
        return EUR;
    }

    public void setEUR(String EUR) {
        this.EUR = EUR;
    }

    public Double getBTC() {
        return BTC;
    }

    public void setBTC(Double BTC) {
        this.BTC = BTC;
    }
}
