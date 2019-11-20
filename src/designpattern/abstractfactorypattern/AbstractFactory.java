package designpattern.abstractfactorypattern;

public abstract  class AbstractFactory {
    public abstract IColor getColor(String color);
    public abstract ISharp getSharp(String sharp);
}
