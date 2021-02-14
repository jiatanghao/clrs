package com.jiatanghao.chapter4;

import java.util.Objects;

public class Complex {
    private final double real;
    private final double image;

    public Complex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public Complex multiply(Complex another) {
        double c1 = this.real * another.image;
        double c2 = this.image * another.real;
        double c3 = (this.real + this.image) * (another.real - another.image);
        return new Complex(c1 + c3 - c2, c1 + c2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.real, real) == 0 && Double.compare(complex.image, image) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, image);
    }
}
