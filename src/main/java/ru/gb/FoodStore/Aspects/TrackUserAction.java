package ru.gb.FoodStore.Aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface TrackUserAction {
}
