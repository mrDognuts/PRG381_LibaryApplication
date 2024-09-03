package model;

/**
 *
 * @author walter
 */
public class BorowingHistory {
            //fields
    protected String borrowingID,borrowersID,bookID,borrowDate;
    
    //constructor
    public BorowingHistory(String borrowingID,String borrowersID, String bookID, String borrowDate){
        this.borrowingID = borrowersID;
        this.borrowersID = borrowersID;
        this.bookID = bookID;
        this.borrowDate = borrowDate;
    }
    @Override
    public String toString(){
        return "borrowingID:"+this.borrowingID+" borrowersID:"+this.borrowersID+" bookID:"+this.bookID+" Borrow Date:"+this.borrowDate;
    }
}

