// servicio

// busqueda de productos por distintos medios, por id, por marca, etc

// por id
public int BusquedaProducto(int id) {
  if (id == getId()) {
    mostrarInformacion();
  } else {
    throw new IllegalArgument("No se encuentra el producto.");
  }

}

// por marca
public String BusquedaMarca(String marca) {
  if (marca == getMarca()) {
    mostrarInformacion();
  } else {
    throw new IllegalArgument("No se encuentra la Marca ingresada.");
  }
}

// por precio

// aciones abm sobre productos
// agregar
// bajar
// modificar
// calculos de precios, etc
// persistencia, guardado y actualizaciones
// historial de cambios
// generacion de reportes
