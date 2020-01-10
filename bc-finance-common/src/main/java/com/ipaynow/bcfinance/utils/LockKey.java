package com.ipaynow.bcfinance.utils;

import com.google.common.base.Objects;

/**
 * @author ytw
 * @date 2019/7/5
 * description:
 */
public class LockKey {

    public LockKey(String userIdOfIPayNowOfDebtor, String userIdOfIPayNowOfCreditor) {
        this.userIdOfIPayNowOfDebtor = userIdOfIPayNowOfDebtor;
        this.userIdOfIPayNowOfCreditor = userIdOfIPayNowOfCreditor;
    }

    private String userIdOfIPayNowOfDebtor;

    private String userIdOfIPayNowOfCreditor;

    public String getUserIdOfIPayNowOfDebtor() {
        return userIdOfIPayNowOfDebtor;
    }

    public void setUserIdOfIPayNowOfDebtor(String userIdOfIPayNowOfDebtor) {
        this.userIdOfIPayNowOfDebtor = userIdOfIPayNowOfDebtor;
    }

    public String getUserIdOfIPayNowOfCreditor() {
        return userIdOfIPayNowOfCreditor;
    }

    public void setUserIdOfIPayNowOfCreditor(String userIdOfIPayNowOfCreditor) {
        this.userIdOfIPayNowOfCreditor = userIdOfIPayNowOfCreditor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LockKey lockKey = (LockKey) o;
        return Objects.equal(userIdOfIPayNowOfDebtor, lockKey.userIdOfIPayNowOfDebtor) &&
                Objects.equal(userIdOfIPayNowOfCreditor, lockKey.userIdOfIPayNowOfCreditor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userIdOfIPayNowOfDebtor, userIdOfIPayNowOfCreditor);
    }
}
