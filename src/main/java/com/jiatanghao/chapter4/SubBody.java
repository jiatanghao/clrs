package com.jiatanghao.chapter4;

import java.util.Objects;

public class SubBody {
    int left;
    int right;
    int value;

    public SubBody(int left, int right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubBody subBody = (SubBody) o;
        return left == subBody.left &&
                right == subBody.right &&
                value == subBody.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, value);
    }
}
