
import org.junit.Before;
import 树.TreeNode;


import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.LongAdder;


import static java.lang.Thread.sleep;

public class Test {


    public static void main(String[] args) throws InterruptedException {
        BigDecimal c = new BigDecimal(1);
        BigDecimal d = new BigDecimal(3);
        LongAdder longAdder = new LongAdder();
         long a =1;
         double b =0.8;
        System.out.println(c.divide(d,2,BigDecimal.ROUND_UP));

    }
}
