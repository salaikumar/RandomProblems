import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SymbolTableTest {


    @Test
    public void shouldSymbolTable() {

//    Test all properties of Implemented symbol table here.\
//    A initial instance with default size 8
     SymbolTable<String, Integer> symbolTable = new SymbolTable<String, Integer>();

     symbolTable.set("Salaikumar" , 1);
     symbolTable.set("Ashwanth" , 2);
     symbolTable.set("Vijay" , 3);
     symbolTable.set("Shilpa" , 4);
     symbolTable.set("Dennis" , 5);
     symbolTable.set("Giri" , 6);
     symbolTable.set("Santhosh" , 7);
     symbolTable.set("Loga" , 8);
     symbolTable.set("Vidhya" , 9);
     symbolTable.set("Kuttan" , 10);
     symbolTable.set("Durga" , 10);

     assertThat(symbolTable.getSize(), is(11));

     // Remove 2 elements and see
     symbolTable.remove("Salaikumar");
     symbolTable.remove("Salaikumar");
     symbolTable.remove("Salaikumar");

     assertThat(symbolTable.getSize(),is(10));
     symbolTable.remove("Durga");
     symbolTable.remove("Kuttan");
     symbolTable.remove("Vidhya");

     assertThat(symbolTable.getSize(),is(7));

     symbolTable.set("Kuttan",14);
     assertThat(symbolTable.getSize(),is(8));
    }
}   