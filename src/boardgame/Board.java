package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException
                    ("Erro ao criar tabuleiro: É necessário que tenha pelo menos uma linha e uma coluna");
            //tratamento de erro caso o usuário tente criar um tabuleiro sem linhas e colunas
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

    public Piece piece(int row, int column) {/*método que cria uma linha e uma coluna*/
        if (!positionExists(row, column)){
            throw new BoardException("Erro: Posição não existe no tabuleiro");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) { /*método que cria uma posição com linha e coluna*/
        if (!positionExists(position)){
            throw new BoardException("Erro: Posição não existe no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) { /*método que cria uma peça na posição indicada*/
        if (thereIsAPiece(position)){
            throw new BoardException("Erro: Já existe uma peça na posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column) { /*método que válida se as linhas e colunas são validas*/
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) { /* método que verifica se existe uma posição com linha e coluna*/
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) { /*método que verifica se há uma peça na posição*/
        if (!positionExists(position)){
            throw new BoardException("Erro: Posição não existe no tabuleiro");
        }
        return piece(position) != null;
    }
}
