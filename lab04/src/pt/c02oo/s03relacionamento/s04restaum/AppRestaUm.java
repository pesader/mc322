package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }

   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      String[] commands = tk.retrieveCommands();
      Tabuleiro tab = new Tabuleiro();

      char[][] mapa = tab.tabuleiroToChars();
      tk.writeBoard("Tabuleiro inicial", mapa);

      for (int l = 0; l < commands.length; l++) {
         String source_str = commands[l].substring(0, 2);
         String target_str = commands[l].substring(3, 5);
         String titulo = "source: " + source_str + "; target: " + target_str;

         Coordenada source = Coordenada.stringToCoordenada(source_str);
         Coordenada target = Coordenada.stringToCoordenada(target_str);

         tab.moverPeca(source, target);
         mapa = tab.tabuleiroToChars();
         tk.writeBoard(titulo, mapa);

      }

      tk.stop();
   }

}
