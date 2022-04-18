package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca[][] tab;
	private int size;

	public Tabuleiro() {
		this.size = 7;
		this.tab = new Peca[size][size];

		char[][] mapa = {
				{ ' ', ' ', 'P', 'P', 'P', ' ', ' ' },
				{ ' ', ' ', 'P', 'P', 'P', ' ', ' ' },
				{ 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
				{ 'P', 'P', 'P', '-', 'P', 'P', 'P' },
				{ 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
				{ ' ', ' ', 'P', 'P', 'P', ' ', ' ' },
				{ ' ', ' ', 'P', 'P', 'P', ' ', ' ' }
		};

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (mapa[i][j] == 'P') {
					Coordenada coord = new Coordenada(i, j);
					Peca p = new Peca(coord, true);
					tab[i][j] = p;
				} else {
					tab[i][j] = null;
				}
			}
		}
	}

	public Peca getPecaAtCoord(Coordenada coord) {
		return tab[coord.getLin()][coord.getCol()];
	}

	public void retirarPecaAtCoord(Coordenada coord) {
		tab[coord.getLin()][coord.getCol()] = null;
	}

	public void moverPeca(Coordenada source, Coordenada target) {
		Peca pm = getPecaAtCoord(source); // peça movida
		if (pm.validarMovimento(target)) {
			pm.setCoord(target);
			tab[target.getLin()][target.getCol()] = pm;
			tab[source.getLin()][source.getCol()] = null;

			Coordenada between = new Coordenada((source.getLin() + target.getLin()) / 2,
					(source.getCol() + target.getCol()) / 2);
			Peca pc = getPecaAtCoord(between); // peça comida
			pc.setAtiva(false);
			tab[between.getLin()][between.getCol()] = null;

		}
	}

	public char[][] tabuleiroToChars() {
		char[][] mapa = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (this.tab[i][j] != null) {
					mapa[i][j] = 'P';
				} else {
					if ((i >= 2 && i <= 4) || (j >= 2 && j <= 4)) {
						mapa[i][j] = '-';
					} else {
						mapa[i][j] = ' ';
					}
				}
			}
		}
		return mapa;
	}

}
