package pt.c02oo.s03relacionamento.s04restaum;

/**
 * Coordenadas de um tabuleiro do jogo "Resta Um".
 * Seus métodos garantem que apenas coordenadas válidas são atribuídas.
 */
public class Coordenada {
	private int lin;
	private int col;
	private static int size;

	/**
	 * Construtor da classe Coordenada
	 * 
	 * @param lin linha da coordenada
	 * @param col coluna da coordenada
	 * @returns uma coordenada completa
	 */
	public Coordenada(int lin, int col) {
		if (validarLinCol(lin, col)) {
			this.lin = lin;
			this.col = col;
		}
		Coordenada.size = 7;
	}

	public int getLin() {
		return lin;
	}

	public int getCol() {
		return col;
	}

	/**
	 * Método de alteração dos atributos de uma coordenada.
	 * Como é necessário verificar ambas linha e coluna para validar uma coordenada,
	 * há um único método setLinCol() ao invés de métodos separados setLin() e
	 * setCol()
	 * 
	 * @param lin linha da coordenada
	 * @param col coluna da coordenada
	 */
	public void setLinCol(int lin, int col) {
		if (validarLinCol(lin, col)) {
			this.lin = lin;
			this.col = col;
		}
	}

	/**
	 * Converte uma String em uma Coordenada.
	 * Ex: Coordenada.stringToCoordenada("a4") -> Coordenada(lin = 3, col = 0)
	 * Ex: Coordenada.stringToCoordenada("f1") -> Coordenada(lin = 0, col = 5)
	 * 
	 * @param str String cujo primeiro caracter é uma letra que representa a coluna
	 *            e o segundo caracter é um número que representa a linha.
	 * @returns um objeto da classe Coordenada
	 */
	public static Coordenada stringToCoordenada(String str) {
		int col = ((int) str.charAt(0)) - 97;
		int lin = ((int) str.charAt(1)) - 49;

		return new Coordenada(lin, col);
	}

	/**
	 * Valida valores de linha e coluna
	 * 
	 * @param lin linha a ser verificada
	 * @param col coluna a ser verificada
	 * @returns <code>true</code> para linha e coluna válidos
	 *          <code>false</code> caso contrário
	 */
	private boolean validarLinCol(int lin, int col) {
		return validar(lin, col) && validar(col, lin);
	}

	/**
	 * Valida uma linha ou coluna da coodernada, considerando que ele deve
	 * <ul>
	 * <li>Estar dentro do tabuleiro de "Resta Um"
	 * <li>Estar dentro da "cruz" do tabuleiro de "Resta Um",
	 * ou seja, nas casas representadas por "o" no diagrama abaixo:
	 *
	 * 0 1 2 3 4 5 6
	 * . . o o o . . 0
	 * . . o o o . . 1
	 * o o o o o o o 2
	 * o o o o o o o 3
	 * o o o o o o o 4
	 * . . o o o . . 5
	 * . . o o o . . 6
	 *
	 * </ul>
	 * 
	 * @param lin_col linha ou coluna que é validada
	 * @param col_lin coluna caso lin_col seja linha
	 *                linha caso lin_col seja coluna
	 * @returns <code>true</code> para linha ou coluna válida,
	 *          <code>false</code> caso contrário.
	 */
	private boolean validar(int lin_col, int col_lin) {
		boolean dentro_do_tabuleiro = (lin_col >= 0 && lin_col < size);
		boolean dentro_da_cruz = (col_lin >= 2 && col_lin <= 4) || (lin_col >= 2 && lin_col <= 4);
		return (dentro_do_tabuleiro && dentro_da_cruz);
	}
}
