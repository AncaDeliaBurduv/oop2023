import java.util.ArrayList;

public interface Calculator {
    public double add(double term1, double term2) throws OverflowException, UnderflowException;
    public double divide(double divided, double divisor);
    public double average(ArrayList<Double> numList) throws NullParameterException, OverflowException, UnderflowException;
}
