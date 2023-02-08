package boardgame;

//Classe Tabuleiro, possui uma quantidade de linhas e colunas para termos o tamanho do mesmo
// E uma matriz de Peças, onde cada peça tem uma posição e é refenciada a um tabuleiro.

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows< 1 || columns < 1) {
			throw new BoardException("Erro ao criar um tabuleiro, valores passados precisam ser maiores que 1");
		}
		this.rows = rows;
		this.columns = columns;
		
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	//Preenchendo/Acessando uma peça que esta em determinada linha, fazendo a verificação se a posição passada existe 
	public Piece piece(int row, int column) {
		if(!positionExistis(row, column)) {
			throw new BoardException("Posição não encontrada!");
		}
		return pieces[row][column];
	}
	
	//Função sobrescrita, onde ao invés de recebermos dois parametros, usamos a classe Position para construirmos 
	//o metodo, classe essa que tem a posição das pessas
	public Piece piece(Position position) {
		if(!positionExistis(position.getRow(), position.getColumn())) {
			throw new BoardException("Posição não encontrada!");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//Função coloca ou troca de lugar a posição das peças, fazendo a verificação se já existe uma peça no lugar, pois se existe não pode ser colocada dessa forma
	public void placePiece(Piece piece, Position position) {
		
		if(thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça nessa posição" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//Verificando se a posição existe
	private boolean positionExistis(int row, int column) {
		return row >= 0 && row < this.rows && column >=0 && column < this.columns; 
	}
	
	//Sobrescrevendo a função e reaproveitando o metodo já criado anteriormente
	public boolean positionExistis(Position position) {
		return positionExistis(position.getRow(), position.getColumn());
	}
	
	//Testando se existe uma peça em determinada posição, pois se a posição for diferente de nulo, significa que existe uma peça nessa posição
	//Verificamos se a posição passada existe, para depois retornarmos a mesma
	public boolean thereIsAPiece(Position position) {
		if(!positionExistis(position.getRow(), position.getColumn())) {
			throw new BoardException("Posição não encontrada!");
		}
		return piece(position) != null;
	}
}
