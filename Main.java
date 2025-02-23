/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import javax.swing.*;
import java.awt.*;

class Punto {
	public float x;
	public float y;
	
	public Punto(float x, float y) {
		this.x = x;
		this.y  = y;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String coord_cartesianas(){
		return "Cordenadas Cartesianas ("+ x +" , "+ y +")";
	}
	public String coord_polares() {
		double p1 = Math.sqrt(x * x + y * y);
		double p2 = Math.toDegrees(Math.atan2(y, x));
		return "Coordenadas polares ("+p1+" , "+p2+")";
	}
        @Override
	public String toString(){
		return "punto ("+x+" , "+y+")";
		
	}

}

class Linea extends JPanel {
    Punto p1, p2;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawLine(Math.round(p1.x * 100), Math.round(p1.y * 100), Math.round(p2.x * 100), Math.round(p2.y * 100));
    }

    public void dibujaLinea() {
        JFrame frame = new JFrame("Dibujar Línea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this); 
        frame.pack(); 
        frame.setVisible(true);
    }
    @Override
    public String toString() {
        return "Linea (" + p1  + p2 +")";
    }
}

class Circulo  extends JPanel {
    Punto centro;
    float radio;

    public Circulo(Punto centro, int radio) {
        this.centro = centro;
        this.radio = radio;
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    public String toString() {
        return "Circulo: (Centro " + centro + ", Radio " + radio +")";
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.drawOval(Math.round(centro.x*10), Math.round(centro.y*10), Math.round(2 * radio * 10),Math.round( 2 * radio * 10));
    }


    public void dibujaCirculo() {
        JFrame frame = new JFrame("Dibujar Círculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }
}


public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(2, 5);
        Punto p2 = new Punto(10, 9);
        Linea linea = new Linea(p1, p2);
        Circulo circulo = new Circulo(new Punto(5, 5), 5);

        System.out.println(linea);
        linea.dibujaLinea();
        System.out.println("-----------------------------");
        System.out.println(circulo);
        circulo.dibujaCirculo();
    }
}

