#ifndef RectanguloH
#define RectanguloH

class Rectangulo : public FigPlana{
	int a;//altura
	int b;//base
	public:
		Rectangulo();//const por defecto
		Rectangulo(int xBase, int xAltura);//const parametrico
		void mBase(int base);//modificar Base, setter
		int oBase();//obtener Base, getter
		void mAltura(int altura);//modificar Altura, setter
		int oAltura();//obtener ALtura, getter
		float calcArea();//calcula y retorna Area
		float calcPerimetro();//calcula y retorna perimetro
		void mostrar();
	
	
	
};


#endif
