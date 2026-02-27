package com.syntaxhelper.search;

import com.syntaxhelper.database.SyntaxDatabase;
import com.syntaxhelper.model.Entry;

import java.util.*;
import java.util.stream.Collectors;

public class Searcher {
  private final SyntaxDatabase db;
  private final Set<String> stopwords;

  public Searcher(SyntaxDatabase db) {
    this.db = db;
    // Stopwords en español (podríamos hacerlas configurables)
    this.stopwords = Set.of("hacer", "un", "una", "como", "para", "con",
        "el", "la", "los", "las", "que", "es", "de", "en", "por", "y", "a");
  }

  public List<ScoredEntry> search(String query) {
    List<String> tokens = tokenize(query);
    if (tokens.isEmpty()) {
      return Collections.emptyList();
    }

    Map<Integer, Integer> scores = new HashMap<>(); // índice -> puntos
    Map<String, List<Integer>> index = db.getInvertedIndex();

    for (String token : tokens) {
      List<Integer> entryIndices = index.get(token);
      if (entryIndices != null) {
        for (int idx : entryIndices) {
          scores.put(idx, scores.getOrDefault(idx, 0) + 1);
        }
      }
    }

    // Ordenar por puntuación descendente y limitar a 5
    return scores.entrySet().stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .limit(5)
        .map(e -> new ScoredEntry(db.getEntries().get(e.getKey()), e.getValue()))
        .collect(Collectors.toList());
  }

  private List<String> tokenize(String query) {
    String lower = query.toLowerCase();
    // Separar por espacios y signos de puntuación comunes
    String[] raw = lower.split("[\\s\\p{Punct}]+");
    List<String> tokens = new ArrayList<>();
    for (String token : raw) {
      token = token.trim();
      if (!token.isEmpty() && !stopwords.contains(token)) {
        tokens.add(token);
      }
    }
    return tokens;
  }

  // Clase auxiliar para resultado con puntuación
  public static class ScoredEntry {
    private final Entry entry;
    private final int score;

    public ScoredEntry(Entry entry, int score) {
      this.entry = entry;
      this.score = score;
    }

    public Entry getEntry() {
      return entry;
    }

    public int getScore() {
      return score;
    }

    @Override
    public String toString() {
      return String.format("  %s\n    Ejemplo: %s\n    Descripción: %s\n",
          entry.getCommand(), entry.getExample(), entry.getDescription());
    }
  }
}
