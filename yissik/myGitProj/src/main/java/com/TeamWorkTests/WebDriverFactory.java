package com.TeamWorkTests;

/**
 * Created by ninja on 28/12/15.
 */
public class WebDriverFactory {
    private String driverType;
    private String driverLocation;
    private String implicitWait;

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getImplicitWait() {
        return implicitWait;
    }

    public void setImplicitWait(String implicitWait) {
        this.implicitWait = implicitWait;
    }
}
