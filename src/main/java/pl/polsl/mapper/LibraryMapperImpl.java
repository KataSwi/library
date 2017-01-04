package pl.polsl.mapper;

import org.springframework.stereotype.Component;
import pl.polsl.dto.*;
import pl.polsl.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katarzyna on 06.12.2016.
 */
@Component
public class LibraryMapperImpl implements LibraryMapper {

    @Override
    public RolesEntity toRolesEntity(RoleDTO roleDTO) {
        if(roleDTO==null){
            return null;
        }
        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setType(roleDTO.getType());
        rolesEntity.setRoleid(roleDTO.getRoleid());
        return rolesEntity;
    }

    @Override
    public List<RolesEntity> toRolesEntityList(List<RoleDTO> roleDTOList) {
        if (roleDTOList == null) {
            return null;
        }
        List<RolesEntity> result = new ArrayList<>();
        roleDTOList.forEach(roleDTO -> result.add(toRolesEntity(roleDTO)));
        return result;
    }

    @Override
    public RoleDTO toRoleDTO(RolesEntity rolesEntity) {
        if (rolesEntity == null) {
            return null;
        }
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleid(rolesEntity.getRoleid());
        roleDTO.setType(rolesEntity.getType());
        return roleDTO;
    }

    @Override
    public List<RoleDTO> toRoleDTOList(List<RolesEntity> rolesEntityList) {
        if (rolesEntityList == null) {
            return null;
        }
        List<RoleDTO> result = new ArrayList<>();
        rolesEntityList.forEach(rolesEntity -> result.add(toRoleDTO(rolesEntity)));
        return result;
    }

    @Override
    public UsersEntity toUsersEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUserName(userDTO.getUserName());
        usersEntity.setName(userDTO.getName());
        usersEntity.setSurname(userDTO.getSurname());
        usersEntity.setPassword(userDTO.getPassword());
        usersEntity.setRoleid(userDTO.getRoleid());
        usersEntity.setEmail(userDTO.getEmail());
        usersEntity.setUsersByRole(toRolesEntity(userDTO.getRoleDTO()));
        return usersEntity;
    }

    @Override
    public List<UsersEntity> toUsersEntityList(List<UserDTO> userDTOList) {
        if (userDTOList == null) {
            return null;
        }
        List<UsersEntity> result = new ArrayList<>();
        userDTOList.forEach(userDTO -> result.add(toUsersEntity(userDTO)));
        return result;
    }

    @Override
    public UserDTO toUserDTO(UsersEntity usersEntity) {
        if (usersEntity == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(usersEntity.getUserName());
        userDTO.setName(usersEntity.getName());
        userDTO.setSurname(usersEntity.getSurname());
        userDTO.setRoleid(usersEntity.getRoleid());
        userDTO.setPassword(usersEntity.getPassword());
        userDTO.setEmail(usersEntity.getEmail());
        userDTO.setRoleDTO(toRoleDTO(usersEntity.getUsersByRole()));
        return userDTO;
    }

    @Override
    public List<UserDTO> toUserDTOList(List<UsersEntity> usersEntityList) {
        if (usersEntityList == null) {
            return null;
        }
        List<UserDTO> result = new ArrayList<>();
        usersEntityList.forEach(usersEntity -> result.add(toUserDTO(usersEntity)));
        return result;
    }

    @Override
    public LibrarianEntity toLibrarianEntity(LibrarianDTO librarianDTO) {
        if(librarianDTO == null){
            return null;
        }
        LibrarianEntity librarianEntity = new LibrarianEntity();
        librarianEntity.setLibrarianid(librarianDTO.getLibrarianid());
        librarianEntity.setUserName(librarianDTO.getUserName());
        librarianEntity.setLibrarianUser(toUsersEntity(librarianDTO.getUserDTO()));
        return librarianEntity;
    }

    @Override
    public List<LibrarianEntity> toLibrarianEntityList(List<LibrarianDTO> librarianDTOList) {
        if (librarianDTOList == null) {
            return null;
        }
        List<LibrarianEntity> result = new ArrayList<>();
        librarianDTOList.forEach(librarianDTO -> result.add(toLibrarianEntity(librarianDTO)));
        return result;
    }

    @Override
    public LibrarianDTO toLibrarianDTO(LibrarianEntity librarianEntity) {
        if (librarianEntity == null) {
            return null;
        }
        LibrarianDTO librarianDTO = new LibrarianDTO();
        librarianDTO.setLibrarianid(librarianEntity.getLibrarianid());
        librarianDTO.setUserName(librarianEntity.getUserName());
        librarianDTO.setUserDTO(toUserDTO(librarianEntity.getLibrarianUser()));
        return librarianDTO;
    }

    @Override
    public List<LibrarianDTO> toLibrarianDTOList(List<LibrarianEntity> librarianEntityList) {
        if (librarianEntityList == null) {
            return null;
        }
        List<LibrarianDTO> result = new ArrayList<>();
        librarianEntityList.forEach(librarianEntity -> result.add(toLibrarianDTO(librarianEntity)));
        return result;
    }

    @Override
    public ReaderEntity toReaderEntity(ReaderDTO readerDTO) {
        if(readerDTO == null){
            return null;
        }
        ReaderEntity readerEntity = new ReaderEntity();
        readerEntity.setCardNumber(readerDTO.getCardNumber());
        readerEntity.setUserName(readerDTO.getUserName());
        readerEntity.setReaderUser(toUsersEntity(readerDTO.getUserDTO()));
        return readerEntity;
    }

    @Override
    public List<ReaderEntity> toReaderEntityList(List<ReaderDTO> readerDTOList) {
        if (readerDTOList == null) {
            return null;
        }
        List<ReaderEntity> result = new ArrayList<>();
        readerDTOList.forEach(readerDTO -> result.add(toReaderEntity(readerDTO)));
        return result;
    }

    @Override
    public ReaderDTO toReaderDTO(ReaderEntity readerEntity) {
        if (readerEntity == null) {
            return null;
        }
        ReaderDTO readerDTO = new ReaderDTO();
        readerDTO.setCardNumber(readerEntity.getCardNumber());
        readerDTO.setUserName(readerEntity.getUserName());
        readerDTO.setUserDTO(toUserDTO(readerEntity.getReaderUser()));
        return readerDTO;
    }

    @Override
    public List<ReaderDTO> toReaderDTOList(List<ReaderEntity> readerEntityList) {
        if (readerEntityList == null) {
            return null;
        }
        List<ReaderDTO> result = new ArrayList<>();
        readerEntityList.forEach(readerEntity -> result.add(toReaderDTO(readerEntity)));
        return result;
    }

    @Override
    public AuthorEntity toAuthorEntity(AuthorDTO authorDTO) {
        if(authorDTO == null){
            return null;
        }
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setAuthorid(authorDTO.getAuthorid());
        authorEntity.setAuthorName(authorDTO.getAuthorName());
        authorEntity.setAuthorSurname(authorDTO.getAuthorSurname());
        return authorEntity;
    }

    @Override
    public List<AuthorEntity> toAuthorEntityList(List<AuthorDTO> authorDTOList) {
        if(authorDTOList == null){
            return null;
        }
        List<AuthorEntity> result = new ArrayList<>();
        authorDTOList.forEach(authorDTO -> result.add(toAuthorEntity(authorDTO)));
        return result;
    }

    @Override
    public AuthorDTO toAuthorDTO(AuthorEntity authorEntity) {
        if(authorEntity == null){
            return null;
        }
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setAuthorid(authorEntity.getAuthorid());
        authorDTO.setAuthorName(authorEntity.getAuthorName());
        authorDTO.setAuthorSurname(authorEntity.getAuthorSurname());
        return authorDTO;
    }

    @Override
    public List<AuthorDTO> toAuthorDTOList(List<AuthorEntity> authorEntityList) {
        if(authorEntityList == null){
            return null;
        }
        List<AuthorDTO> result = new ArrayList<>();
        authorEntityList.forEach(authorEntity -> result.add(toAuthorDTO(authorEntity)));
        return result;
    }

    @Override
    public BookcopyEntity toBookCopyEntity(BookCopyDTO bookCopyDTO) {
        if(bookCopyDTO == null){
            return null;
        }
        BookcopyEntity bookcopyEntity = new BookcopyEntity();
        bookcopyEntity.setInventory(bookCopyDTO.getInventory());
        bookcopyEntity.setIsbn(bookCopyDTO.getIsbn());
        bookcopyEntity.setState(bookCopyDTO.getState());
        bookcopyEntity.setBookCopy(toBookEntity(bookCopyDTO.getBookDTO()));
        bookcopyEntity.setBookByState(toBookStateEntity(bookCopyDTO.getStateDTO()));
        return bookcopyEntity;
    }

    @Override
    public List<BookcopyEntity> toBookCopyEntityList(List<BookCopyDTO> bookCopyDTOList) {
        if(bookCopyDTOList == null){
            return null;
        }
        List<BookcopyEntity> result = new ArrayList<>();
        bookCopyDTOList.forEach(bookCopyDTO -> result.add(toBookCopyEntity(bookCopyDTO)));
        return result;
    }

    @Override
    public BookCopyDTO toBookCopyDTO(BookcopyEntity bookcopyEntity) {
        if(bookcopyEntity == null){
            return null;
        }
        BookCopyDTO bookCopyDTO = new BookCopyDTO();
        bookCopyDTO.setInventory(bookcopyEntity.getInventory());
        bookCopyDTO.setIsbn(bookcopyEntity.getIsbn());
        bookCopyDTO.setState(bookcopyEntity.getState());
        bookCopyDTO.setBookDTO(toBookDTO(bookcopyEntity.getBookCopy()));
        bookCopyDTO.setStateDTO(toBookStateDTO(bookcopyEntity.getBookByState()));
        return bookCopyDTO;
    }

    @Override
    public List<BookCopyDTO> toBookCopyDTOList(List<BookcopyEntity> bookcopyEntityList) {
        if(bookcopyEntityList == null){
            return null;
        }
        List<BookCopyDTO> result = new ArrayList<>();
        bookcopyEntityList.forEach(bookcopyEntity -> result.add(toBookCopyDTO(bookcopyEntity)));
        return result;
    }

    @Override
    public GenreEntity toGenreEntity(GenreDTO genreDTO) {
        if(genreDTO == null){
            return null;
        }
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setGenreid(genreDTO.getGenreid());
        genreEntity.setType(genreDTO.getType());
        return genreEntity;
    }

    @Override
    public List<GenreEntity> toGenreEntityList(List<GenreDTO> genreDTOList) {
        if(genreDTOList == null){
            return null;
        }
        List<GenreEntity> result = new ArrayList<>();
        genreDTOList.forEach(genreDTO -> result.add(toGenreEntity(genreDTO)));
        return result;
    }

    @Override
    public GenreDTO toGenreDTO(GenreEntity genreEntity) {
        if(genreEntity == null){
            return null;
        }
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setGenreid(genreEntity.getGenreid());
        genreDTO.setType(genreEntity.getType());
        return genreDTO;
    }

    @Override
    public List<GenreDTO> toGenreDTOList(List<GenreEntity> genreEntityList) {
        if(genreEntityList == null){
            return null;
        }
        List<GenreDTO> result = new ArrayList<>();
        genreEntityList.forEach(genreEntity -> result.add(toGenreDTO(genreEntity)));
        return result;
    }

    @Override
    public BookstateEntity toBookStateEntity(BookStateDTO bookStateDTO) {
        if(bookStateDTO == null){
            return null;
        }
        BookstateEntity bookstateEntity = new BookstateEntity();
        bookstateEntity.setStateid(bookStateDTO.getStateid());
        bookstateEntity.setState(bookStateDTO.getState());
        return bookstateEntity;
    }

    @Override
    public List<BookstateEntity> toBookStateEntityList(List<BookStateDTO> bookStateDTOList) {
        if (bookStateDTOList == null){
            return null;
        }
        List<BookstateEntity> result = new ArrayList<>();
        bookStateDTOList.forEach(bookStateDTO -> result.add(toBookStateEntity(bookStateDTO)));
        return result;
    }

    @Override
    public BookStateDTO toBookStateDTO(BookstateEntity bookstateEntity) {
        if(bookstateEntity == null){
            return null;
        }
        BookStateDTO bookStateDTO = new BookStateDTO();
        bookStateDTO.setStateid(bookstateEntity.getStateid());
        bookStateDTO.setState(bookstateEntity.getState());
        return bookStateDTO;
    }

    @Override
    public BookEntity toBookEntity(BookDTO bookDTO) {
        if(bookDTO == null){
            return null;
        }
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(bookDTO.getIsbn());
        bookEntity.setAuthor(bookDTO.getAuthorid());
        bookEntity.setBookByAuthor(toAuthorEntity(bookDTO.getAuthorDTO()));
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setPages(bookDTO.getPages());
        bookEntity.setGenre(bookDTO.getGenreid());
        bookEntity.setBookByGenre(toGenreEntity(bookDTO.getGenreDTO()));
        bookEntity.setPublisher(bookDTO.getPublisher());
        return bookEntity;
    }

    @Override
    public List<BookEntity> toBookEntityList(List<BookDTO> bookDTOList) {
        if(bookDTOList == null){
            return null;
        }
        List<BookEntity> result = new ArrayList<>();
        bookDTOList.forEach(bookDTO -> result.add(toBookEntity(bookDTO)));
        return result;
    }

    @Override
    public BookDTO toBookDTO(BookEntity bookEntity) {
        if (bookEntity == null){
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn(bookEntity.getIsbn());
        bookDTO.setAuthorid(bookEntity.getAuthor());
        bookDTO.setTitle(bookEntity.getTitle());
        bookDTO.setPages(bookEntity.getPages());
        bookDTO.setPublisher(bookEntity.getPublisher());
        bookDTO.setAuthorDTO(toAuthorDTO(bookEntity.getBookByAuthor()));
        bookDTO.setGenreDTO(toGenreDTO(bookEntity.getBookByGenre()));
        bookDTO.setGenreid(bookEntity.getGenre());
        return bookDTO;
    }

    @Override
    public List<BookDTO> toBookDTOList(List<BookEntity> bookEntityList) {
        if (bookEntityList == null){
            return null;
        }
        List<BookDTO> result = new ArrayList<>();
        bookEntityList.forEach(bookEntity -> result.add(toBookDTO(bookEntity)));
        return result;
    }

    @Override
    public BorrowedbooksEntity toBorrowedBooksEntity(BorrowedBooksDTO borrowedBooksDTO) {
        if(borrowedBooksDTO == null){
            return null;
        }
        BorrowedbooksEntity borrowedbooksEntity = new BorrowedbooksEntity();
        borrowedbooksEntity.setBorrowid(borrowedBooksDTO.getBorrowid());
        borrowedbooksEntity.setReaderCard(borrowedBooksDTO.getReaderCard());
        borrowedbooksEntity.setBookInventory(borrowedBooksDTO.getBookInventory());
        borrowedbooksEntity.setBookByReader(toBookCopyEntity(borrowedBooksDTO.getBookCopyDTO()));
        borrowedbooksEntity.setBorrowedDate(borrowedBooksDTO.getBorrowedDate());
        borrowedbooksEntity.setReturnDate(borrowedBooksDTO.getReturnDate());
        return borrowedbooksEntity;
    }

    @Override
    public List<BorrowedbooksEntity> toBorrowedBooksEntityList(List<BorrowedBooksDTO> borrowedBooksDTOList) {
        if(borrowedBooksDTOList == null){
            return null;
        }
        List<BorrowedbooksEntity> result = new ArrayList<>();
        borrowedBooksDTOList.forEach(borrowedBooksDTO -> result.add(toBorrowedBooksEntity(borrowedBooksDTO)));
        return result;
    }

    @Override
    public BorrowedBooksDTO toBorrowedBooksDTO(BorrowedbooksEntity borrowedbooksEntity) {
        if(borrowedbooksEntity == null){
            return null;
        }
        BorrowedBooksDTO borrowedBooksDTO = new BorrowedBooksDTO();
        borrowedBooksDTO.setBorrowid(borrowedbooksEntity.getBorrowid());
        borrowedBooksDTO.setReaderCard(borrowedbooksEntity.getReaderCard());
        borrowedBooksDTO.setBookInventory(borrowedbooksEntity.getBookInventory());
        borrowedBooksDTO.setBookCopyDTO(toBookCopyDTO(borrowedbooksEntity.getBookByReader()));
        borrowedBooksDTO.setBorrowedDate(borrowedbooksEntity.getBorrowedDate());
        borrowedBooksDTO.setReturnDate(borrowedbooksEntity.getReturnDate());
        return borrowedBooksDTO;
    }

    @Override
    public List<BorrowedBooksDTO> toBorrowedBooksDTOList(List<BorrowedbooksEntity> borrowedbooksEntityList) {
        if(borrowedbooksEntityList == null){
            return null;
        }
        List<BorrowedBooksDTO> result = new ArrayList<>();
        borrowedbooksEntityList.forEach(borrowedbooksEntity -> result.add(toBorrowedBooksDTO(borrowedbooksEntity)));
        return result;
    }

    @Override
    public ReservationEntity toReservationEntity(ReservationDTO reservationDTO) {
        if(reservationDTO == null){
            return null;
        }
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setReservationid(reservationDTO.getReservationid());
        reservationEntity.setReservedBook(reservationDTO.getBookInventory());
        reservationEntity.setReaderCard(reservationDTO.getReaderCard());
        reservationEntity.setBookByReservation(toBookCopyEntity(reservationDTO.getBookCopyDTO()));
        reservationEntity.setExpDate(reservationDTO.getExpDate());
        return reservationEntity;
    }

    @Override
    public List<ReservationEntity> toReservationEntityList(List<ReservationDTO> reservationEntityList) {
        if(reservationEntityList == null){
            return null;
        }
        List<ReservationEntity> result = new ArrayList<>();
        reservationEntityList.forEach(reservationDTO -> result.add(toReservationEntity(reservationDTO)));
        return result;
    }

    @Override
    public ReservationDTO toReservationDTO(ReservationEntity reservationEntity) {
        if(reservationEntity == null){
            return null;
        }
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservationid(reservationEntity.getReservationid());
        reservationDTO.setBookInventory(reservationEntity.getReservedBook());
        reservationDTO.setReaderCard(reservationEntity.getReaderCard());
        reservationDTO.setBookCopyDTO(toBookCopyDTO(reservationEntity.getBookByReservation()));
        reservationDTO.setExpDate(reservationEntity.getExpDate());
        return reservationDTO;
    }

    @Override
    public List<ReservationDTO> toReservationDTOList(List<ReservationEntity> reservationEntityList) {
        if (reservationEntityList == null){
            return null;
        }
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        reservationEntityList.forEach(reservationEntity -> reservationDTOs.add(toReservationDTO(reservationEntity)));
        return reservationDTOs;
    }
}
