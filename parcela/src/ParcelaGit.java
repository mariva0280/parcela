abstract class Figura {
    abstract public double area();
    abstract public double perimetro();
    abstract public double perimetroReal();
}
class Circulo extends Figura {
    private double diametro;
    public Circulo(double diametro) throws Exception {
        if (diametro <= 0) throw new Exception();
        this.diametro = diametro;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.diametro/2,2);
    }

    @Override
    public double perimetro() {
        return Math.PI * this.diametro;
    }

    @Override
    public double perimetroReal() {
        return perimetro();
    }
}
class Semicirculo extends Circulo {

    public Semicirculo(double diametro) throws Exception {
        super(diametro);
    }
    @Override
    public double area() {
        return super.area() / 2;
    }
    @Override
    public double perimetro() {
        return super.perimetro()/2;
    }
    @Override
    public double perimetroReal() {
        return super.perimetro()/2;
    }

}
class Rectangulo extends Figura {
    private double lado1;
    private double lado2;
    public Rectangulo(double lado1,double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double area() {
        return lado1 * lado2;
    }

    @Override
    public double perimetro() {
        return (lado1 + lado2) * 2;
    }

    @Override
    public double perimetroReal() {
        return lado1;
    }
}
class Cuadrado extends Rectangulo {
    private double lado;
    public Cuadrado(double lado) {

        super(lado, lado);
    }

    public double getLado() {
        return lado;
    }
    @Override
    public double perimetroReal() {
        return (lado + lado) + lado / 2;
    }
}
class TrianguloRectangulo extends Figura {
    private double base;
    private double altura;
    private double hipotenusa;
    public TrianguloRectangulo(double base,double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getAltura() {

        return altura;
    }

    public double getBase() {
        return base;
    }
    public double getHipotenusa() {
        return hipotenusa;
    }

    @Override
    public double area() {
        return (base * altura) / 2;

    }

    @Override
    public double perimetro() {
        double hipotenusa = Math.sqrt(Math.pow(base,2) + Math.pow(altura,2));
        return base + altura + hipotenusa;
    }

    @Override
    public double perimetroReal() {
        //double hipotenusa = Math.sqrt(Math.pow(base,2) + Math.pow(altura,2));
        return altura + hipotenusa;
    }
}
class TrianguloEquilatero extends TrianguloRectangulo {

    public TrianguloEquilatero(double base, double altura) {

        super(base/2, altura);
    }

    @Override
    public double area() {
        return super.area()*2;
    }
    @Override
    public double perimetro() {
        return super.perimetro()-getAltura()-getAltura();
    }
    @Override
    public double perimetroReal() {
        return perimetro()+getHipotenusa()-getBase();
    }
}
class Parcela extends Figura {
    private Figura [] figuras;
    private double precio;
    public Parcela (Figura [] figuras) {
        this.figuras = figuras;
        this.precio = precio;
    }
    @Override
    public double area() {
        double result = 0.0;
        for(Figura figura : figuras) {
            result += figura.area();
        }
        return result;
    }
    @Override
    public double perimetro() {
        double result = 0.0;
        for(Figura figura : figuras) {
            result += figura.perimetro();
        }
        return result;
    }

    @Override
    public double perimetroReal() {
        double result = 0.0;
        for(Figura figura : figuras) {
            result += figura.perimetroReal();
        }
        return result;
    }

    public double expropiacion (double precio) {
        double total = 0.0;
        total = precio * area();
        return total;
    }

}

public class ParcelaGit {
    public static void main(String[] args) throws Exception {

        Parcela parcela = new Parcela(new Figura[]{new TrianguloEquilatero(6.00,4.00),new TrianguloRectangulo(2.00,3.00),new Rectangulo(8.00,4.00),new Cuadrado(4.00),new Circulo(4.00)});

        double area = parcela.area();
        System.out.println("El area de la parcela dada es: " +area);

        double expropiacion = parcela.expropiacion(32.00);
        System.out.println("El precio de la expropiacion de la parcela es:" +expropiacion);

        double perimetro = parcela.perimetro();
        System.out.println("El perimetro de la parcela es: " + perimetro);


        double perimetro_real = parcela.perimetroReal();
        System.out.println("El perímetro real de la parcela es: " + perimetro_real);




    }



}