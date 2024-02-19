package io.realm;


public interface CourseRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public int realmGet$credit_hours();
    public void realmSet$credit_hours(int value);
    public String realmGet$lecturer();
    public void realmSet$lecturer(String value);
    public boolean realmGet$core();
    public void realmSet$core(boolean value);
    public boolean realmGet$registered();
    public void realmSet$registered(boolean value);
}
