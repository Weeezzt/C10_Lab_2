package org.example.c10_lab_2.location.dto;

import lombok.Getter;

public class LocationRequest {

    private float longitude;
    private float latitude;
    private double radius;

    // Getters and Setters

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
