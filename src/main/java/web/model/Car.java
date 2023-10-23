package web.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Car {
    private final String model;
    private final String series;
    private final int year;

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }

    public int getYear() {
        return year;
    }
}
