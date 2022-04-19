package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private Coordenada coord;
	private Tabuleiro tab;
	private boolean ativa;

	/**
	 * Construtor da classe Peca.
	 * O atributo tab é inicialmente nulo, para evitar a chamada do construtor da
	 * classe Tabuleiro dentro do construtor da classe Peca
	 * 
	 * @param coord coordenada da peça
	 * @param ativa <code>true</code> se a peça está ativa
	 *              <code>false</code> caso contrário
	 */
	public Peca(Coordenada coord, boolean ativa) {
		this.coord = coord;
		this.ativa = ativa;
		this.tab = null;
	}

	public Coordenada getCoord() {
		return coord;
	}

	public void setCoord(Coordenada coord) {
		this.coord = coord;
	}

	public boolean validarMovimento(Coordenada target) {
		Coordenada source = this.coord;

		if (source.getCol() == target.getCol()) {
			Coordenada between = new Coordenada((source.getLin() + target.getLin()) / 2, target.getCol());
			return ((Math.abs(source.getLin() - target.getLin()) == 2)
					&& this.tab.getPecaAtCoord(source) != null
					&& this.tab.getPecaAtCoord(source).isAtiva()
					&& this.tab.getPecaAtCoord(between) != null
					&& this.tab.getPecaAtCoord(between).isAtiva());

		} else if (source.getLin() == target.getLin()) {
			Coordenada between = new Coordenada(target.getLin(), (source.getCol() + target.getCol()) / 2);
			System.out.println("mesma linha");
			return ((Math.abs(source.getCol() - target.getCol()) == 2)
					&& this.tab.getPecaAtCoord(source) != null
					&& this.tab.getPecaAtCoord(source).isAtiva()
					&& this.tab.getPecaAtCoord(between) != null
					&& this.tab.getPecaAtCoord(between).isAtiva());

		} else {
			return false;
		}
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public Tabuleiro getTab() {
		return tab;
	}

	public void setTab(Tabuleiro tab) {
		this.tab = tab;
	}

}
