package spy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTests {

    @Test
    public void arrayListTests() {

        List<String> list = Mockito.spy(new ArrayList<>());

        list.add("element 1");
        list.add("element 2");

        Assertions.assertThat(list).containsExactly("element 1", "element 2");

        Assertions.assertThat(list.size()).isEqualTo(2);
        Mockito.when(list.size()).thenReturn(100);
        Assertions.assertThat(list.size()).isEqualTo(100);

        Mockito.verify(list).add("element 1");
        Mockito.verify(list).add("element 2");

        Mockito.verify(list, Mockito.never()).add("element 3");
    }
}
