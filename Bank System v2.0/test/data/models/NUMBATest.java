package data.models;

import org.junit.jupiter.api.Test;

class NUMBATest {

    @Test
    public void testing(){
        NUMBA numba = new NUMBA(123456, 444);
        System.out.print(numba.getNumba());
    }

}