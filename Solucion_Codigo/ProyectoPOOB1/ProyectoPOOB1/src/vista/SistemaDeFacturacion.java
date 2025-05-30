package vista;

import controlador.SistemaController;
import java.time.LocalDate;
import java.util.*;

public class SistemaDeFacturacion {
    private static SistemaController ctrl = new SistemaController();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n--- MENÚ SUPERMAXI ---");
            System.out.println("1) Registrar Cliente");
            System.out.println("2) Agregar Producto");
            System.out.println("3) Hacer Factura");
            System.out.println("4) Ver Estadísticas");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opt = sc.nextInt(); sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.print("ID: ");      String id   = sc.nextLine();
                    System.out.print("Nombre: ");  String nom  = sc.nextLine();
                    System.out.print("Correo: ");  String mail = sc.nextLine();
                    System.out.print("Teléfono: ");int tel    = sc.nextInt(); sc.nextLine();
                    System.out.print("Dirección: "); String dir = sc.nextLine();
                    ctrl.registrarCliente(id, nom, mail, tel, dir);
                    System.out.println("Cliente registrado.");
                    break;

                case 2:
                    System.out.print("Nombre Producto: "); String np = sc.nextLine();
                    System.out.print("Categoría: ");      String cat = sc.nextLine();
                    System.out.print("Precio normal: ");   double pn  = sc.nextDouble();
                    System.out.print("Precio promo: ");    double pp  = sc.nextDouble();
                    System.out.print("Stock inicial: ");   int st     = sc.nextInt(); sc.nextLine();
                    System.out.print("Caducidad (YYYY-MM-DD): ");
                    LocalDate cad = LocalDate.parse(sc.nextLine());
                    ctrl.agregarProductoInventario(np, cat, pn, pp, st, cad);
                    System.out.println("Producto agregado.");
                    break;

                case 3:
                    List<modelo.Cliente> lis = ctrl.getClientes();
                    for (int i = 0; i < lis.size(); i++) {
                        System.out.printf("%d) %s\n", i, lis.get(i));
                    }
                    System.out.print("Cliente #: ");
                    int ci = sc.nextInt(); sc.nextLine();

                    List<String> cods = new ArrayList<>();
                    char r;
                    do {
                        System.out.print("Código producto: ");
                        cods.add(sc.nextLine());
                        System.out.print("Otro? (S/N): ");
                        r = sc.nextLine().toUpperCase().charAt(0);
                    } while (r == 'S');

                    modelo.Factura f = ctrl.crearFactura(ci, cods);
                    System.out.println("\n" + f);
                    break;

                case 4:
                    System.out.println("\n" + ctrl.getEstadistica());
                    break;
            }
        } while (opt != 0);
        sc.close();
        System.out.println("Fin.");
    }
}
