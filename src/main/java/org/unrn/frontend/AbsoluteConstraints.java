package org.unrn.frontend;

import java.io.Serializable;

public class AbsoluteConstraints implements Serializable {
    static final long serialVersionUID = 5261460716622152494L;
    public int x;
    public int y;
    public int width;
    public int height;

    public AbsoluteConstraints(int var1, int var2, int var3, int var4) {
        this.x = var1;
        this.y = var2;
        this.width = var3;
        this.height = var4;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String toString() {
        return super.toString() + " [x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + "]";
    }
}

