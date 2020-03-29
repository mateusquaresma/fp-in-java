import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionTest {

    @Test
    public void testHighCompose(){
        Function<Double, Integer> f = x -> (int) (x * 3);
        Function<Long, Double> g = x -> x + 2.0;

        Integer result = Function.<Long, Double, Integer>higherCompose().apply(f).apply(g).apply(1L);
        assertEquals(Integer.valueOf(9), f.apply((g.apply(1L))));
        assertEquals(Integer.valueOf(9),
                Function.<Long, Double, Integer>higherCompose().apply(f).apply(g).apply(1L));

    }
}