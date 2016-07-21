#include <iostream>
#include "FigPlana.h"
#include "Rectangulo.h"
using namespace std;
//Constructor por defecto
Rectangulo::Rectangulo(){
	a=0;
	b=0;
}
//Constructor parametrico
Rectangulo::Rectangulo(int xBase, int xAltura){
	a=xAltura;
	b=xBase;
}

//modificar altura
Rectangulo::mAltura(int altura){
	a=altura;	
}

//obtener altura
Rectangulo::oAltura(){
	return a;
}

//modificar base
Rectangulo::mBase(int base){
	b=base;
}

//obtener base
Rectangulo::oBase(){
	return b;
}

Rectangulo::mostrar(){
	FigPlana::mostrar();
}
