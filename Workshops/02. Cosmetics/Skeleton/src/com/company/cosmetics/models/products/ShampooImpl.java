package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {
    private int milliliters;
    private UsageType usageType;
    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType everyDay) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        setUsageType(everyDay);
    }

    @Override
    public int getMilliliters() {
        return this.milliliters;
    }

    public void setMilliliters(int milliliters) {
        super.validateNegativeValue("milliliters",milliliters);
        this.milliliters = milliliters;
    }
    @Override
    public UsageType getUsage() {
        return this.usageType;
    }
    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    @Override
    public String print() {
        return String.format("%s #Milliliters: %d%n #Usage: %s%n ===",
                super.print(),
                getMilliliters(),
                getUsage()
        );
    }

}
