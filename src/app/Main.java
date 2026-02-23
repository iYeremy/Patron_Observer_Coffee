package app;

import subject.CoffeeCorporate;
import observer.Barista;

public class Main {
    public static void main(String[] args) {

        // Creamos la cooperativa
        CoffeeCorporate cooperativa = new CoffeeCorporate();

        // Creamos baristas
        Barista barista1 = new Barista("Ana", "B001", cooperativa);
        Barista barista2 = new Barista("Carlos", "B002", cooperativa);
        Barista barista3 = new Barista("Luisa", "B003", cooperativa);

        System.out.println("=== Registrando microlotes ===");

        // Registramos un microlote válido
        cooperativa.addLot(
            "Geisha",
            "Notas de jazmín, frutas cítricas, acidez media alta, final prolongado",
            "Génova, Quindío",
            "1.500 msnm",
            45
        );

        // Intentamos registrar un microlote que supera el límite
        cooperativa.addLot(
            "Bourbón Rosado",
            "Frutos rojos, moras, cereza, caramelo, acidez media alta, residual a cacao",
            "Acevedo, Huila",
            "1.250 msnm",
            60
        );

        // Registramos otro microlote dentro del límite
        cooperativa.addLot(
            "Java",
            "Notas a chocolate y nuez, acidez media, cuerpo completo",
            "Salento, Quindío",
            "1.400 msnm",
            30
        );

        System.out.println("=== Eliminando suscripción de Carlos ===");
        cooperativa.removeObserver(barista2);

        // Registramos un nuevo microlote después de remover la suscripción
        cooperativa.addLot(
            "Tabi",
            "Frutas tropicales, acidez brillante, final a miel",
            "Acevedo, Huila",
            "1.350 msnm",
            25
        );
    }
}