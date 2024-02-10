package io.realm;


public interface BookRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$author();
    public void realmSet$author(String value);
    public boolean realmGet$reserved();
    public void realmSet$reserved(boolean value);
    public boolean realmGet$me_reserved();
    public void realmSet$me_reserved(boolean value);
    public String realmGet$genre();
    public void realmSet$genre(String value);
    public String realmGet$img();
    public void realmSet$img(String value);
}
