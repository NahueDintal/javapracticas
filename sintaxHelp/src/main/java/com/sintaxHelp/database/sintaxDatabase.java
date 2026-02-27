package com.syntaxhelper.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syntaxhelper.model.Entry;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class SyntaxDatabase {
  private List<Entry> entries;
  private Map<String, List<Integer>> invertedIndex; // palabra -> índices de entries
  private static final ObjectMapper mapper = new ObjectMapper();

  public SyntaxDatabase(String context) throws IOException {
    loadEntries(context);
    buildInvertedIndex();
  }

  private void loadEntries(String context) throws IOException {
    // Buscar primero en el directorio del usuario (~/.syntax-help/context.json)
    String userHome = System.getProperty("user.home");
    File userFile = new File(userHome + "/.syntax-help/" + context + ".json");
    if (userFile.exists()) {
      entries = mapper.readValue(userFile, new TypeReference<List<Entry>>() {
      });
      return;
    }

    // Si no, cargar desde recursos (classpath:/data/context.json)
    InputStream is = getClass().getResourceAsStream("/data/" + context + ".json");
    if (is == null) {
      throw new IOException("No se encontró la base de datos para el contexto: " + context);
    }
    entries = mapper.readValue(is, new TypeReference<List<Entry>>() {
    });
  }

  private void buildInvertedIndex() {
    invertedIndex = new HashMap<>();
    for (int i = 0; i < entries.size(); i++) {
      Entry entry = entries.get(i);
      for (String keyword : entry.getKeywords()) {
        String key = normalizeKeyword(keyword);
        invertedIndex.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
      }
    }
  }

  private String normalizeKeyword(String keyword) {
    return keyword.toLowerCase().trim();
  }

  public List<Entry> getEntries() {
    return entries;
  }

  public Map<String, List<Integer>> getInvertedIndex() {
    return invertedIndex;
  }
}
