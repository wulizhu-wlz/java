package com.ipaynow.bcfinance.cmb.contract;

import com.cryptape.cita.tuples.generated.Tuple2;
import com.cryptape.cita.tuples.generated.Tuple4;
import com.cryptape.cita.tuples.generated.Tuple6;
import com.ipaynow.bcfinance.cmb.contract.helper.FinancialHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ytw
 * @date 2019/7/11
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FinancialHelperTests {

    private static final char HEX_CHAR_ARR[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @Resource
    private FinancialHelper financialHelper;

    @Test
    public void queryloan() {
        Tuple6<String, String, byte[], byte[], byte[], BigInteger> result = financialHelper.queryloan("2425");
        System.out.println(result.getValue1());
        System.out.println(result.getValue2());
        System.out.println(byteArrToHex(result.getValue3()));
        System.out.println(byteArrToHex(result.getValue4()));
        System.out.println(byteArrToHex(result.getValue5()));
        System.out.println(result.getValue6());
    }

    @Test
    public void queryRepay() {
        Tuple4<String, String, String, byte[]> result = financialHelper.queryRepay("2425");
        System.out.println(result.getValue1());
        System.out.println(result.getValue2());
        System.out.println(result.getValue3());
        System.out.println(byteArrToHex(result.getValue4()));
    }

    @Test
    public void queryRepayByLoanId() {
        Tuple2<List<byte[]>, List<byte[]>> result = financialHelper.queryRepayByLoanId("2425");
        List<String> repayIds = new ArrayList<>(result.getValue1().size());
        List<String> hashList = new ArrayList<>(result.getValue2().size());
        result.getValue1().forEach((byte[] repayId) -> {
            repayIds.add(FinancialHelperTests.byteArrToHex(repayId));
        });
        result.getValue2().forEach((byte[] hash) -> {
            hashList.add(FinancialHelperTests.byteArrToHex(hash));
        });
        System.out.println(repayIds);
        System.out.println(hashList);
    }


    public static String byteArrToHex(byte[] btArr) {

        char strArr[] = new char[btArr.length * 2];
        int i = 0;
        for (byte bt : btArr) {
            strArr[i++] = HEX_CHAR_ARR[bt >>> 4 & 0xf];
            strArr[i++] = HEX_CHAR_ARR[bt & 0xf];
        }
        return new String(strArr);
    }
}
