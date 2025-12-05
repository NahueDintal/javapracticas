import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.nio.file.Files;
import java.nio.file.*;
import java.io.IOException;

public class Main {
  public static void Interface() {

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

    switch (comando) {
      case "init":
        inicializarTasker(directorioTareas);
        break;
      case "add":
      case "a":
      case "new":
        agregarTarea(args, directorioTareas, archivoTareas);
        break;
      case "list":
      case "ls":
        ListarTareas(archivoTareas);
        break;
      case "delete":
      case "del":
      case "rm":
        if (args.Length < 2) {
          System.out.println(MensjErrorId);
          System.out.println(MensjUso);
          return;
        }
        eliminarTarea(args[1], archivoTareas);
        break;
      case "status":
        mostrarEstado(directorioTareas, archivoTareas);
        break;
      case "ok":
      case "c":
      case "complete":
        if (args.Length < 2) {
          System.out.println(MensjErrorId);
          System.out.println(MensjUso);
          return;
        }
        completarTarea(args[1], archivoTareas);
        break;
      default:
        System.out.println("Comando no reconocido: " + comando);
        imprimirAyuda();
        break;
    }
  }

  public static void inicializarTasker(String directorioTareas) {
    Path path = Paths.get(directorioTareas);
    try {
      if (!Files.exists(path)) {
        Files.createDirectory(path);
        System.out.println("Tasker inicializado en: " + directorioTareas);
        System.out.println("Ahora puedes agregar tareas específicas de este proyecto.");
      } else {
        System.out.println("Tasker ya está inicializado en este directorio.");
      }
    } catch (IOException e) {
      System.err.println("Error al iniciar tasker: " + e.getMessage());
    } catch (InvalidPathException e) {
      System.err.println("La ruta del directorio es inválida: " + directorioTareas);
    }
  }

  static void AgregarTarea(String[] args, String directorioTareas, String archivoTareas) {
    Path dirpath = Paths.get(directorioTareas);
    Path filepath = Paths.get(archivoTareas);
    if (!Files.exists(dirpath)) {
      System.out.println("Tasker no está inicializado en este directorio.");
      System.out.println("Ejecuta primero: tasker init");
      return;
    }
    if (!Files.exists(filepath)) {
      Files.createFile(filepath);
      System.out.println("Archivo de tareas creado" + archivoTareas);
    }

    String nombre = null;
    String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/mm/yyyy"));
    String descripcion = "Sin descripción";
    String tipo = "Sin tipo";
    String prioridad = "media";

    for (int i = 1; i < args.length; i++) {
      switch (args[i]) {
        case "-n":
          if (i + 1 < args.length)
            nombre = args[++i];
          break;
        case "-f":
          if (i + 1 < args.length) {
            String fechaInput = args[++i];
            try {
              LocalDate.parse(fechaInput, DateTimeFormatter.ofPattern("dd/mm/yyyy"));
              fecha = fechaInput;
            } catch (DateTimeParseException e) {
              System.err.println("Formato de fecha inválido.");
              System.err.println("Esperando formato dd/mm/yyyy");
            }
          }
          break;
        case "-d":
          if (i + 1 < args.length)
            descripcion = args[++i];
          break;
        case "-t":
          if (i + 1 < args.length)
            tipo = args[++i];
          break;
        case "-p":
          if (i + 1 < args.length) {
            prioridad = args[++i].toLowerCase();
            if (p.equals("alta") || p.equals("media") || p.equals("alta")) {
              prioridad = p;
            } else {
              System.err.println("Prioridad inválida, usando 'media'.");
              System.err.println("Opciones válidas: alta, media, baja");
            }
          }
          break;
        default:
          System.out.println("Opción desconocida: " + args);
          return;
      }
    }
  }

  static void listarTareas(String archivoTareas)
  {
    if (!File.exists(archivoTareas))
    {
      System.out.println($"No hay tareas guardadas en este proyecto ({Path.GetFileName(Environment.CurrentDirectory)})");
      System.out.println("Para empezar: tasker init && tasker add -n \"Mi primera tarea\"");
      return;
    }

    System.out.println($"Tareas del proyecto: {Path.GetFileName(Environment.CurrentDirectory)}");
    System.out.println(new string('-', 50));

    foreach (string linea in File.ReadAllLines(archivoTareas))
    {
      String[] partes = linea.Split('|');
      String estado = partes.Length >= 7 ? partes[6] : "pendiente";
      String indicadorEstado = estado == "completada" ? "✅" : "⭕";
      if (partes.length >= 6)
      {
        // Mostrar con indicador de estado
        System.out.println(indicadorEstado + partes[0],3 + partes[1]);
        System.out.println("Fecha: " + partes[2] +" | Tipo: "+ partes[4] +" | Prioridad: "+ partes[5] +"| Estado: "+ estado");
        if (partes[3] != "Sin descripción")
          Console.WriteLine("Descripción: "+ partes[3]);
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
