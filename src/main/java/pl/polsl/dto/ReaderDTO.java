package pl.polsl.dto;

/**
 * Created by Katarzyna on 06.12.2016.
 */
public class ReaderDTO {
    private long cardNumber;
    private String userName;
    private UserDTO userDTO;

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
