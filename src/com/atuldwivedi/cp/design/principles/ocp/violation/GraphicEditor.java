package com.atuldwivedi.cp.design.principles.ocp.violation;

/**
 * @author Atul Dwivedi
 * @date 11/07/21
 */
//  Violation of Open Close Principle - bad design
public class GraphicEditor {
    public void drawShape(Shape shape) {
        if (shape.type == 1) {
            drawCircle((Circle) shape);
        } else if (shape.type == 2) {
            drawRectangle((Rectangle) shape);
        }
    }

    public void drawCircle(Circle circle) {
        circle.drawCircle();
    }

    public void drawRectangle(Rectangle rectangle) {
        rectangle.drawRectangle();
    }

    //for testing purpose only
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Rectangle());
        //New shape: Triangle - which class needs to be changed? - GraphicEditor
    }
}

class Shape {
    int type;
}

class Circle extends Shape {
    public Circle() {
        super.type = 1;
    }

    void drawCircle() {
        System.out.println("Drawing circle...");
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        super.type = 2;
    }

    void drawRectangle() {
        System.out.println("Drawing rectangle...");
    }
}
