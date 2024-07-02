package Models;

import java.util.Date;

public class Payment extends BaseModel{
    private PaymentMode paymentMode;
    private int Amount;
    private PaymentStatus paymentStatus;
    private String RefID;
    private Bill bill;
    private Date PaymentTime;

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getRefID() {
        return RefID;
    }

    public void setRefID(String refID) {
        RefID = refID;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Date getPaymentTime() {
        return PaymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        PaymentTime = paymentTime;
    }
}
