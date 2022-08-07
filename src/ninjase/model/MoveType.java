package ninjase.model;

public enum MoveType {
	Up(-1, 0), Down(1, 0), Left(0, -1), Right(0, 1),
	none(0, 0);
	
	final int deltaR;
	final int deltaC;
	
	MoveType(int dr, int dc){
		this.deltaR = dr;
		this.deltaC = dc;
	}
}
