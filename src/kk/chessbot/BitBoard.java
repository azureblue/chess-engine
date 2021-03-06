package kk.chessbot;

public class BitBoard {
    public final static BitBoard MASK_ALL = new BitBoard(0xffffffffffffffffL);
    private long boardBits = 0;

    public BitBoard() {
    }

    public BitBoard(long boardBits) {
        this.boardBits = boardBits;
    }

    public void clear() {
        boardBits = 0;
    }

    public void clear(int pos) {
        boardBits &= ~(1L << (long) pos);
    }

    public boolean get(int x, int y) {
        return (boardBits >> (y << 3 | x) & 1) == 1;
    }

    public void set(int pos) {
        boardBits |= 1L << (long) pos;
    }

    public long getBoardBits() {
        return boardBits;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64 + 8);
        for (int y = 7; y >= 0; y--) {
            for (int x = 0; x < 8; x++) {
                boolean b = get(x, y);
                if (b)
                    sb.append("#");
                else
                    sb.append(".");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void setBits(long boardBits) {
        this.boardBits = boardBits;
    }
}
