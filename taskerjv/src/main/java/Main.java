import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Main {
  public static void main(String[] args) {

    if (args.length == 0 || args[0] == "-h" || args[0] == "--help") {
      imprimirAyuda();
      return;
    }

    String directorioActual = System.getProperty("user.dir");
    String directorioTareas = Paths.get(directorioActual, ".tasker").toString();
    String archivoTareas = Paths.get(directorioTareas, "tasks.txt").toString();
    String MensjErrorId = "Error: Se requiere un ID";
    String MensjUso = "Uso: tasker <COMANDO> ";
    String comando = args[0].toLowerCase();

    switch (comando)
    {
      case "init": InicializarTasker(directorioTareas); break;
      case "add":
      case "a":
      case "new":
        AgregarTarea(args, directorioTareas, archivoTareas); break;
      case "list":
      case "ls": ListarTareas(archivoTareas); break;
      case "delete":
      case "del":
      case "rm":
        if (args.Length < 2)
        {
          System.out.println(MensjErrorId);
          System.out.println(MensjUso);
          return;
        }
        EliminarTarea(args[1], archivoTareas); break;
      case "status": MostrarEstado(directorioTareas, archivoTareas); break;
      case "ok":
      case "c":
      case "complete":
        if (args.Length < 2)
        {
          System.out.println(MensjErrorId);
          System.out.println(MensjUso);
          return;
        }
        CompletarTarea(args[1], archivoTareas); break;
      default:
        System.out.println($"Comando no reconocido: {comando}");
        imprimirAyuda();
        break;
    }
  }

  public static void InicializarTasker(String directorioTareas) {
    if (!Files.exists(directorioTareas)) {
      Files.createDirectory(directorioTareas);
      System.out.println("Tasker inicializado en: " + directorioTareas);
      System.out.println("Ahora puedes agregar tareas específicas de este proyecto.");
    } else {
      System.out.println("Tasker ya está inicializado en este directorio.");
    }
  }

  public static void imprimirAyuda() {
    System.out.println("Tasker - Gestor de tareas por directorio.");
    System.out.println();
    System.out.println("USO:");
    System.out.println("  tasker <COMANDO> [OPCIONES]");
    System.out.println();
    System.out.println("COMANDOS:");
    System.out.println("  init                                Inicializar tasker en el directorio actual");
    System.out.println("  add, a, new                         Agregar una nueva tarea al direcotorio actual");
    System.out.println("  list, ls                            Listar tareas del directorio actual");
    System.out.println("  delete, del, rm                     Eliminar una tarea por ID");
    System.out.println("  complete, ok, c                     Completar tarea por ID");
    System.out.println("  status                              Mostrar estado en el directorio actual");
    System.out.println("  -h, --help                          Mostrar esta ayuda");
    System.out.println();
    System.out.println("OPCIONES PARA 'add':");
    System.out.println("  -n <nombre>                         Nombre de la tarea (OBLIGATORIO)");
    System.out.println("  -f <fecha>                          Fecha de la tarea");
    System.out.println("  -d <descripción>                    Descripción de la tarea");
    System.out.println("  -t <tipo>                           Tipo de tarea");
    System.out.println("  -p <prioridad>                      Prioridad (alta, media, baja)");
    System.out.println();
    System.out.println("FLUJO DE TRABAJO:");
    System.out.println("  1. tasker init                    # Inicializar en un proyecto");
    System.out.println("  2. tasker add -n \"Mi tarea\"       # Agregar tareas");
    System.out.println("  3. tasker list                    # Ver tareas del proyecto");
    System.out.println("  4. tasker complete                # Cambiar estado de la tarea a completado");
    System.out.println();
    System.out.println("EJEMPLOS:");
    System.out.println("  tasker init");
    System.out.println("  tasker add -n \"Implementar login\" -p alta");
    System.out.println("  tasker add -n \"Documentar API\" -t documentación");
    System.out.println("  tasker list");
    System.out.println("  tasker complete 2");
    System.out.println("  tasker delete 1");
    System.out.println("  tasker status");
  }

}
