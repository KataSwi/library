package pl.polsl.dto;

/**
 * Created by Katarzyna on 08.12.2016.
 */
public class BookCopyDTO {
    private long inventory;
    private String isbn;
    private int state;
    private BookDTO bookDTO;
    private BookStateDTO stateDTO;

    public long getInventory() {
        return inventory;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public BookStateDTO getStateDTO() {
        return stateDTO;
    }

    public void setStateDTO(BookStateDTO stateDTO) {
        this.stateDTO = stateDTO;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
