package davi.Mandelbrot;



public class Complex {
	private double real;
	private double imag;
	
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	public Complex()
	{
		
	}
	
	public Complex mult(Complex c1, Complex c2)
	{
		Complex result = new Complex(0, 0);
		
		result.real = ((c1.real*c2.real) - (c1.imag*c2.imag));
		result.imag = ((c1.real*c2.imag) + (c1.imag*c2.real));
		
		return result;
	}
	public Complex add(Complex c1, Complex c2)
	{
		Complex result = new Complex(0, 0);
		
		result.real = c1.real+c2.real;
		result.imag = c1.imag+c2.imag;
		
		return result;
	}
	
	public Complex div(Complex c1, Complex c2)
	{
		Complex result = new Complex(0, 0);
		
		result.real = (c1.real*c2.real + c1.imag*c2.imag)/(Math.pow(c2.real, 2) + Math.pow(c2.imag, 2));
		result.imag = (c2.imag*c2.real - c1.real*c2.imag)/(Math.pow(c2.real, 2) + Math.pow(c2.imag, 2));
		
		return result;
	}
	
	public Complex sub(Complex c1, Complex c2)
	{
		Complex result = new Complex(0, 0);
		
		result.real = c1.real-c2.real;
		result.imag = c1.imag-c2.imag;
		
		return result;
	}
	
	public double magnitude()
	{	
		return Math.sqrt((Math.pow(this.real, 2) + Math.pow(this.imag, 2)));
	}
	
	public void print()
	{
		System.out.println("Real: "+ this.real + " Imag: "+ this.imag);
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
}
