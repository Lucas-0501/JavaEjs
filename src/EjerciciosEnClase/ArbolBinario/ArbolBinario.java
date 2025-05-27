package EjerciciosEnClase.ArbolBinario;

// Clase Nodo que representa cada nodo del árbol
class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

// Clase Árbol Binario
public class ArbolBinario {
    Nodo raiz;

    // Método para insertar un valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        return nodo;
    }

    // Método para recorrer el árbol en orden
    public void enOrden() {
        enOrdenRecursivo(raiz);
    }

    private void enOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            enOrdenRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            enOrdenRecursivo(nodo.derecho);
        }
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido en orden del árbol:");
        arbol.enOrden();
    }
}