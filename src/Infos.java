import java.util.Date;

public class Infos {

    int index;
    String code;
    String unit;
    String currency;
    String forexBuying;
    String forexSelling;
    String banknoteBuying;
    String BanknoteSelling;
    Date date;


    public Infos(int index,String code,String currencyName,String BanknoteBuying,String BanknoteSelling,String ForexBuying,String ForexSelling,String Unit) {
        this.index = index;
        this.code = code;
        this.unit = Unit;
        this.currency = currencyName;
        this.forexBuying = ForexBuying;
        this.forexSelling = ForexSelling;
        this.banknoteBuying = BanknoteBuying;
        this.BanknoteSelling = BanknoteSelling;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getForexBuying() {
        return forexBuying;
    }

    public void setForexBuying(String forexBuying) {
        this.forexBuying = forexBuying;
    }

    public String getForexSelling() {
        return forexSelling;
    }

    public void setForexSelling(String forexSelling) {
        this.forexSelling = forexSelling;
    }

    public String getBanknoteBuying() {
        return banknoteBuying;
    }

    public void setBanknoteBuying(String banknoteBuying) {
        this.banknoteBuying = banknoteBuying;
    }

    public String getBanknoteSelling() {
        return BanknoteSelling;
    }

    public void setBanknoteSelling(String banknoteSelling) {
        BanknoteSelling = banknoteSelling;
    }
}
