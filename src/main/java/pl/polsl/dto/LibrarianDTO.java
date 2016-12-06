package pl.polsl.dto;

/**
 * Created by Katarzyna on 06.12.2016.
 */
public class LibrarianDTO {
    private long librarianid;
    private String userName;
    private UserDTO userDTO;

    public long getLibrarianid() {
        return librarianid;
    }

    public void setLibrarianid(long librarianid) {
        this.librarianid = librarianid;
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
