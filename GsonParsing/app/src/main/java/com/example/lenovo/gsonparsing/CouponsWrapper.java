package com.example.lenovo.gsonparsing;

/**
 * Created by lenovo on 2/15/2018.
 */
import java.util.List;

public class CouponsWrapper {
    private List<Coupon> coupons;

    public List<Coupon> getCouponList() {
        return coupons;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.coupons = couponList;
    }
}