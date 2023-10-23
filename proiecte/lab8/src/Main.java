import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MyCalculator calc=new MyCalculator();
        double s, c, m;
        ArrayList<Double> l1=new ArrayList<>();
        ArrayList<Double> l2=null;
        ArrayList<Double> l3=new ArrayList<>();
        ArrayList<Double> l4=new ArrayList<>();

        try{
            System.out.println(calc.add(10.2,7.51));
        }
        catch (OverflowException e){
            System.out.println("Overflow Exception: "+ e.getMessage());
        } catch (UnderflowException e) {
            System.out.println("Underflow Exception: "+ e.getMessage());
        }

        try {
            System.out.println(calc.add(10.2,Double.POSITIVE_INFINITY));
        }
        catch (OverflowException e){
            System.out.println("Overflow Exception: "+ e.getMessage());
        } catch (UnderflowException e) {
            System.out.println("Underflow Exception: "+ e.getMessage());
        }

        try {
            System.out.println(calc.add(10.2,Double.NEGATIVE_INFINITY));
        }
        catch (OverflowException e){
            System.out.println("Overflow Exception: "+ e.getMessage());
        } catch (UnderflowException e) {
            System.out.println("Underflow Exception: " + e.getMessage());
        }

        System.out.println(calc.divide(10.2,7.51));

        l1.add(10.2);
        l1.add(7.51);
        l1.add(-16.3);
        l1.add(54.0);

        try {
            System.out.println(calc.average(l1));
        } catch (NullParameterException e) {
            System.out.println("Null Parameter Exception: "+e.getMessage());;
        } catch (OverflowException e) {
            System.out.println("Overflow Exception: "+ e.getMessage());
        } catch (UnderflowException e) {
            System.out.println("Underflow Exception: "+ e.getMessage());
        }

        try {
            System.out.println(calc.average(l2));
        } catch (NullParameterException e) {
            System.out.println("Null Parameter Exception: "+e.getMessage());;
        } catch (OverflowException e) {
            System.out.println("Overflow Exception: "+ e.getMessage());
        } catch (UnderflowException e) {
            System.out.println("Underflow Exception: "+ e.getMessage());
        }

        l3.add(10.2);
        l3.add(7.51);
        l3.add(-16.3);
        l3.add(Double.POSITIVE_INFINITY);

        try {
            System.out.println(calc.average(l3));
        } catch (NullParameterException e) {
            System.out.println("Null Parameter Exception: "+e.getMessage());;
        } catch (OverflowException e) {
            System.out.println("Overflow Exception: "+ e.getMessage());
        } catch (UnderflowException e) {
            System.out.println("Underflow Exception: "+ e.getMessage());
        }

        l4.add(10.2);
        l4.add(7.51);
        l4.add(Double.NEGATIVE_INFINITY);
        l4.add(54.0);

        try {
            System.out.println(calc.average(l4));
        } catch (NullParameterException e) {
            System.out.println("Null Parameter Exception: "+e.getMessage());;
        } catch (OverflowException e) {
            System.out.println("Overflow Exception: "+ e.getMessage());
        } catch (UnderflowException e) {
            System.out.println("Underflow Exception: "+ e.getMessage());
        }
    }
}