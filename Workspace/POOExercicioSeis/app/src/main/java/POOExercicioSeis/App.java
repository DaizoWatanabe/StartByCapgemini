package POOExercicioSeis;

public class App {

    public static void main(String[] args) {

        Invoice invoice;
        invoice = new Invoice(5, "abajur", 3, 15.33f);

        double total = invoice.getInvoiceAmount();

        System.out.println("Your invoice total is: " + total);
    }
}
