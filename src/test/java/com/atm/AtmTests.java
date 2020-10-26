package com.atm;

import com.atm.actions.AtmOperations;
import com.atm.dto.BillsDTO;
import com.atm.services.AtmRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtmTests {

//    @Before
//    public void setup() {
//        System.setProperty("java.net.useSystemProxies", "true");
//    }

    @Autowired
    private AtmRepository atmRepository;

    AtmOperations atmOperations = new AtmOperations();

    @Test
    public void testWithdrawAlgorithm() {
        BillsDTO testObject = setObjectTestValues(new BillsDTO());
        BillsDTO result = atmOperations.withdrawAlgorithm(1369, atmRepository.findAllByOrderByIdDesc());
        assertThat(result, samePropertyValuesAs(testObject));
    }

    private BillsDTO setObjectTestValues(BillsDTO testObject) {
        testObject.set_1(4);
        testObject.set_5(1);
        testObject.set_10(1);
        testObject.set_50(1);
        testObject.set_100(1);
        testObject.set_200(1);
        testObject.set_500(2);

        return testObject;
    }
}
