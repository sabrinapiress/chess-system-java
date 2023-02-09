package chess;

import boardgame.Position;

//Classe de modificação das posições, pois na construção da matris acessamos as posições por numero,
//porem a forma como é passada essa posição para a mudança da mesma é com letras e numeros.
public class ChessPosition {
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro ChessPosition. Valores validos são somente de a1 à h8");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	
	//Fazemos a operação que diminui o tamanho da linha de acordo com o tamanho do tabuleiro, pois se nosso tabuleiro tem 8 linhas e diminuimos o valor da linha passada por parametro, nos retorna a posição dentro da matriz
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}

	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}

}
