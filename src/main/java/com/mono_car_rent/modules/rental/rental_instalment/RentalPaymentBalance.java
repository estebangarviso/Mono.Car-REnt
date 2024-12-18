package com.mono_car_rent.modules.rental.rental_instalment;

import java.util.List;

public class RentalPaymentBalance {
    private int totalInstalments;
    private List<PaymentInstalment> paymentInstalments;

    RentalPaymentBalance(int totalInstalments, List<PaymentInstalment> paymentInstalments) {
        this.totalInstalments = totalInstalments;
        this.paymentInstalments = paymentInstalments;
    }

    public static RentalPaymentBalanceBuilder builder() {
        return new RentalPaymentBalanceBuilder();
    }

    public void paidFirstInstalment() {
        paymentInstalments.get(0).pay();
    }

    public double getTotalValue() {
        return paymentInstalments.stream().mapToDouble(PaymentInstalment::getValue).sum();
    }

    public void payInstalment(int number) {
        paymentInstalments.get(number).pay();
    }

    public void unpayInstalment(int number) {
        paymentInstalments.get(number).unpay();
    }

    public int getTotalInstalments() {
        return this.totalInstalments;
    }

    public List<PaymentInstalment> getPaymentInstalments() {
        return this.paymentInstalments;
    }

    public static class RentalPaymentBalanceBuilder {
        private int totalInstalments;
        private List<PaymentInstalment> paymentInstalments;

        RentalPaymentBalanceBuilder() {
        }

        public RentalPaymentBalanceBuilder totalInstalments(int totalInstalments) {
            this.totalInstalments = totalInstalments;
            return this;
        }

        public RentalPaymentBalanceBuilder paymentInstalments(List<PaymentInstalment> paymentInstalments) {
            this.paymentInstalments = paymentInstalments;
            return this;
        }

        public RentalPaymentBalance build() {
            return new RentalPaymentBalance(this.totalInstalments, this.paymentInstalments);
        }

        public String toString() {
            return "RentalPaymentBalance.RentalPaymentBalanceBuilder(totalInstalments=" + this.totalInstalments + ", paymentInstalments=" + this.paymentInstalments + ")";
        }
    }
}
