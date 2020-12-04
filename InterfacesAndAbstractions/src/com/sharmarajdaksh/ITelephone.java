package com.sharmarajdaksh;

public interface ITelephone {
    // All methods in an interface are public by default
    // Any variables must be static final
    public void powerOn();
    public void dial(int phoneNumber);
    public void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
}
