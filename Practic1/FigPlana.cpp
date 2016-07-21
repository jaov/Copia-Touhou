#include <iostream>
#include "FigPlana.h"
using namespace std;
FigPlana::mostrar(){
	cout<<"El codigo es: "<<this->codigo;
}
FigPlana::mCodigo(xCodigo){
	this->codigo=xCodigo;
}
FigPlana::oCodigo(){
	return this->codigo;
}
