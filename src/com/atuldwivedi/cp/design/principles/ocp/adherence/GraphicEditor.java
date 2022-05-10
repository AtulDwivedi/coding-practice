package com.atuldwivedi.cp.design.principles.ocp.adherence;

/**
 * @author Atul Dwivedi
 * @date 11/07/21
 */
//  Adherence of Open Close Principle - good design
public class GraphicEditor {
    public void drawShape(Shape shape) {
        shape.draw();
    }

    //for testing purpose only
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Rectangle());
        //New shape: Triangle
        graphicEditor.drawShape(new Triangle());
    }
}

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing circle...");
    }
}

class Rectangle extends Shape {
    void draw() {
        System.out.println("Drawing rectangle...");
    }
}

//just new class, no change is needed in GraphEditor
class Triangle extends Shape {
    void draw() {
        System.out.println("Drawing triangle...");
    }
}
