package com.github.dzikismigol.fakeslots;

import javax.inject.Singleton;

@Singleton
public class Configuration {
    private static Configuration instance;

    private int fakeSlots;
    private int realSlots;

    private Configuration() {
    }

    public void setFakeSlots(int slots) {
        this.fakeSlots = slots;
    }

    public void setRealSlots(int slots) {
        this.realSlots = slots;
    }

    public int getFakeSlots() {
        return this.fakeSlots;
    }

    public int getRealSlots() {
        return this.realSlots;
    }

    public static Configuration getInstance() {
        if (Configuration.instance == null) {
            Configuration.instance = new Configuration();
        }

        return Configuration.instance;
    }
}
