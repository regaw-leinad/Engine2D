package com.regawmod.engine2d;

public class Vector2f
{
    private float x;
    private float y;

    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float length()
    {
        return (float)Math.sqrt(x * x + y * y);
    }

    public float dot(Vector2f r)
    {
        return x * r.getX() + y * r.getY();
    }

    public Vector2f normalize()
    {
        float length = this.length();

        this.x /= length;
        this.y /= length;

        return this;
    }

    public Vector2f rotate(float angle)
    {
        double radians = Math.toRadians(angle);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        return new Vector2f((float)(x * cos - y * sin), (float)(x * sin - y * cos));
    }

    public Vector2f add(Vector2f r)
    {
        return new Vector2f(x + r.getX(), y + r.getY());
    }

    public Vector2f add(float r)
    {
        return new Vector2f(x + r, y + r);
    }

    public Vector2f subtract(Vector2f r)
    {
        return new Vector2f(x - r.getX(), y - r.getY());
    }

    public Vector2f subtract(float r)
    {
        return new Vector2f(x - r, y - r);
    }

    public Vector2f multiply(Vector2f r)
    {
        return new Vector2f(x * r.getX(), y * r.getY());
    }

    public Vector2f multiply(float r)
    {
        return new Vector2f(x * r, y * r);
    }

    public Vector2f divide(Vector2f r)
    {
        return new Vector2f(x / r.getX(), y / r.getY());
    }

    public Vector2f divide(float r)
    {
        return new Vector2f(x / r, y / r);
    }

    @Override
    public String toString()
    {
        return "(" + x + " " + y + ")";
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }
}
