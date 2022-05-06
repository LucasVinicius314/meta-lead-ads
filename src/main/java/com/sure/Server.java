package com.sure;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
  private Server() {
  }

  static public void setup() {
    try {
      final var server = HttpServer.create(new InetSocketAddress(Integer.parseInt(Env.port)), 0);

      server.createContext("/", new RootHandler());
      server.createContext("/redirect", new RedirectHandler());

      server.setExecutor(null);
      server.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static class RootHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
      try {
        final var path = Paths.get(getClass().getResource("/view/index.html").toURI());

        final var out = Files.readString(path);

        t.sendResponseHeaders(200, out.length());

        final var os = t.getResponseBody();

        os.write(out.getBytes());

        os.close();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    }
  }

  static class RedirectHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
      final var method = t.getRequestMethod();
      final var uri = t.getRequestURI();
      final var headers = t.getRequestHeaders().entrySet().stream()
          .map(e -> new String[] { e.getKey(), e.getValue().stream().collect(Collectors.joining()) })
          .flatMap((e) -> Stream.of(e)).collect(Collectors.joining());
      final var is = t.getRequestBody();

      final var isBytes = is.readAllBytes();

      final var requestBody = new String(isBytes, StandardCharsets.UTF_8);

      final var out = new StringBuilder().append(method).append(' ').append(uri).append('\n').append(headers)
          .append('\n').append(requestBody).toString();

      System.out.println(out);

      t.sendResponseHeaders(200, out.length());

      final var os = t.getResponseBody();

      os.write(out.getBytes());

      os.close();
    }
  }
}
