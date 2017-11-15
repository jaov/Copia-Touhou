#ifndef CirculoH
#define CirculoH
 class Circulo : public FigPlana{
 	float radio;
 	float diametro;
 	public:
 		void mRadio(); //modificar Radio, setter
 		float oRadio(); //obtener Radio, getter
 		void mDiametro(); //modificar Diametro, setter
 		float oDiametro(); //obtener Diametro, getter
 		float calcArea(); //calcula y devuelve area
 		float calcPerimetro(); //calcula y devuelve perimetro
 		void mostrar();
 		Circulo();
 		Circulo(xRadio, xDiametro);
 };


#endif 
