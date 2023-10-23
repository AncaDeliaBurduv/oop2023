import java.util.ArrayList;

public class MyCalculator implements Calculator{

    /**
     * O metoda care aduna doua numere
     * @param term1 primul termen al adunarii
     * @param term2 al doilea termen al adunarii
     * @return suma celor doi termeni
     * @throws OverflowException este aruncata daca suma celor doi termeni este egala cu Double.POSITIVE_INFINITY
     * @throws UnderflowException este aruncata daca suma celor doi termeni este egala cu Double.NEGATIVE_INFINITY
     */
    @Override
    public double add(double term1, double term2) throws OverflowException, UnderflowException {
        if(term1+term2==Double.POSITIVE_INFINITY)
            throw new OverflowException("Suma numerelor "+term1+" si "+term2+" este prea mare.");
        if(term1+term2==Double.NEGATIVE_INFINITY)
            throw new UnderflowException("Suma numerelor "+term1+" si "+term2+" este prea mica.");
        return term1+term2;
    }

    /**
     * O metoda care imparte un numar la altul
     * @param divided deimpartitul impartirii
     * @param divisor impartitorul impartirii
     * @return catul impartirii deimpartitului la impartitor
     */
    @Override
    public double divide(double divided, double divisor) {
        return divided/divisor;
    }

    /**
     * O metoda care calculeaza media unor numere dintr-o lista
     * @param numList o lista de obiecte Double
     * @return media valorilor din lista
     * @throws NullParameterException este aruncata daca lista este nula
     * @throws OverflowException este aruncata daca suma unor numere din lista este egala cu Double.POSITIVE_INFINITY
     * @throws UnderflowException este aruncata daca suma unor numere din lista este egala cu Double.NEGATIVE_INFINITY
     */
    @Override
    public double average(ArrayList<Double> numList) throws NullParameterException, OverflowException,
                                                            UnderflowException {
        if(null==numList)
            throw new NullParameterException("Lista elementelor este nula");
        double s=0;
        for(Double nr: numList){
            s=add(s,nr);
        }
        return divide(s,numList.size());
    }
}
