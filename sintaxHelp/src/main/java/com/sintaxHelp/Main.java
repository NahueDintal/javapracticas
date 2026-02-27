package com.syntaxhelper;

import com.syntaxhelper.database.SyntaxDatabase;
import com.syntaxhelper.search.Searcher;

import java.io.Console;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static final String VERSION = "1.0";

  public static void main(String[] args) {
    if (args.length == 0 || args[0].equals("--help") || args[0].equals("-h")) {
      printHelp();
      return;
    }

    String context = args[0];
    String query = args.length > 1 ? String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length)) : null;

    try {
      SyntaxDatabase db = new SyntaxDatabase(context);
      Searcher searcher = new Searcher(db);

      if (query == null) {
        // Modo interactivo
        runInteractive(searcher, context);
      } else {
        // Consulta única
        printResults(searcher.search(query), query, System.out);
      }
    } catch (IOException e) {
      System.err.println("Error al cargar la base de datos para '" + context + "': " + e.getMessage());
      System.exit(1);
    }
  }

  private static void runInteractive(Searcher searcher, String context) {
    Console console = System.console();
    if (console == null) {
      // Si no hay console (por ejemplo, redirección), usar Scanner
      Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
      System.out.println("Modo interactivo para " + context + ". Escribe 'salir' para terminar.");
      while (true) {
        System.out.print(context + "-help> ");
        if (!scanner.hasNextLine())
          break;
        String line = scanner.nextLine().trim();
        if (line.equalsIgnoreCase("salir") || line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) {
          break;
        }
        if (!line.isEmpty()) {
          printResults(searcher.search(line), line, System.out);
        }
      }
    } else {
      // Usar console para mejor manejo de entrada/salida
      console.printf("Modo interactivo para %s. Escribe 'salir' para terminar.\n", context);
      String line;
      while ((line = console.readLine("%s-help> ", context)) != null) {
        if (line.equalsIgnoreCase("salir") || line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) {
          break;
        }
        if (!line.isEmpty()) {
          printResults(searcher.search(line), line, console.writer());
        }
      }
    }
  }

  private static void printResults(List<Searcher.ScoredEntry> results, String query, PrintStream out) {
    if (results.isEmpty()) {
      out.println("No se encontraron resultados para: " + query);
    } else {
      out.println("Resultados para '" + query + "':");
      int i = 1;
      for (Searcher.ScoredEntry se : results) {
        out.println(i++ + ". " + se);
      }
    }
  }

  private static void printResults(List<Searcher.ScoredEntry> results, String query, java.io.Writer writer) {
    // Versión para PrintWriter de console
    PrintStream ps = new PrintStream(System.out); // simplificado, pero console ya tiene su writer
    printResults(results, query, ps);
  }

  private static void printHelp() {
    System.out.println("Syntax Helper v" + VERSION);
    System.out.println("Uso: <contexto> [consulta]");
    System.out.println("  contexto: bash, java, podman, kubernetes, ...");
    System.out.println("  consulta: texto en lenguaje natural (opcional).");
    System.out.println("Si no se proporciona consulta, entra en modo interactivo.");
    System.out.println("Ejemplos:");
    System.out.println("  bash-help \"hacer directorio\"");
    System.out.println("  java-help");
  }
}
