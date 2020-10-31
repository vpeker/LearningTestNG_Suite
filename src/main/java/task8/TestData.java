package task8;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider
    public Object[][] getData(){
        Object[][] data=new Object[3][2];

        data[0][0]="mngr136913";
        data[0][1]="abc321!";

        data[1][0]="mngr136913";
        data[1][1]="abc321!";

        data[2][0]="mngr136913";
        data[2][1]="abc321!";
        return data;
    }
}
