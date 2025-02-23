import matplotlib.pyplot as plt
import math

class Punto:
    def __init__(self, x , y):
        self.X = x
        self.Y = y
    def coord_cartesiana(self):
        return "Coordenadas {} {}".format(self.X, self.Y)
    def coord_polares(self):
        p1 = ((self.X)**2 + (self.Y)**2)**(1/2)
        p2 = math.degrees(math.atan2(self.Y, self.X))
        return "Coordenadas polares {} {:.2f}".format(p1,p2)
    def __str__(self):
        return f"Punto {self.X , self.Y}"
    def getX(self):
        return self.X
    def getY(self):
        return self.Y

class Linea:
    def __init__(self, p1:Punto, p2:Punto):
        self.p1 = p1
        self.p2 = p2

    def __str__(self):
        return f"Linea {self.p1},{self.p2}"
    
    def dibujaLinea(self):
        x = [self.p1.getX(), self.p2.getX()]
        y = [self.p1.getY(), self.p2.getY()]
        plt.plot(x,y, marker='o', linestyle='-')
        plt.show()
        

class Circulo:
    def __init__(self, centro:Punto, radio):
        self.centro = centro
        self.radio = radio

    def __str__(self):
        return f"Circulo({self.centro},{self.radio})"
    
    def dibujaCirculo(self):
        centro = (self.centro.getX(), self.centro.getY())
        radio = self.radio
        
        fig, ax = plt.subplots()
        
        circulo = plt.Circle(centro, radio, color='b', fill=False)
        ax.add_patch(circulo)

        ax.set_xlim(centro[0] - radio - 1, centro[0] + radio + 1)
        ax.set_ylim(centro[1] - radio - 1, centro[1] + radio + 1)
        ax.set_aspect('equal')
        plt.show()
k = Punto(60,80)
r = Circulo(k,40)
print(r)
r.dibujaCirculo()
print("-----------------------------------------------")
p1 = Punto(3,5)
p2 = Punto(57,18)
l = Linea(p1, p2)
print(l)
l.dibujaLinea()
   
