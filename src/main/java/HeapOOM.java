import java.util.*;

/**
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
  */

public class HeapOOM {

    public static void main (String[] args){
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern() );
        }
    }
}
